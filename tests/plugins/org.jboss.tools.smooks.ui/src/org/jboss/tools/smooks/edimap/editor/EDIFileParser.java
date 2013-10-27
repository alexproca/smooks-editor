/*******************************************************************************
 * Copyright (c) 2008 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.edimap.editor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jboss.tools.smooks.configuration.editors.uitls.SmooksUIUtils;
import org.jboss.tools.smooks.configuration.editors.xml.TagList;
import org.jboss.tools.smooks.configuration.editors.xml.TagObject;
import org.jboss.tools.smooks.edimap.models.EDIDataContainerModel;

/**
 * @author Dart dpeng@redhat.com
 * 
 */
public class EDIFileParser {
	public TagList parserEDIFile(String path, char segment, char field, char component, char subcomponent)
			throws InvocationTargetException, IOException {
		TagList tl = new TagList();
		path = SmooksUIUtils.parseFilePath(path);
		if (!new File(path).exists())
			return new TagList();
		InputStream stream = new FileInputStream(path);
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		StringBuffer stringBuffer = new StringBuffer();
		List<String> segmentList = new ArrayList<String>();
		int readed = -1;
		while ((readed = br.read()) != -1) {
			if (readed != segment) {
				stringBuffer.append((char) readed);
			} else {
				segmentList.add(stringBuffer.toString());
				stringBuffer = null;
				stringBuffer = new StringBuffer();
			}
		}
		if (stringBuffer != null && stringBuffer.toString().length() > 0) {
			segmentList.add(stringBuffer.toString());
			stringBuffer = null;
		}
		br.close();
		reader.close();
		stream.close();
		List<String> names = new ArrayList<String>();
		char[] separators = new char[] { field, component, subcomponent };
		for (Iterator<?> iterator = segmentList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			String[] fields = string.split("\\" + new String(new char[] { field })); //$NON-NLS-1$
			TagObject tag = null;
			if (fields.length != 0) {
				if (names.indexOf(fields[0]) == -1) {
					tag = new EDIDataContainerModel();
					((EDIDataContainerModel) tag).setMultipe(false);
					tag.setName(fields[0].trim());
					names.add(tag.getName());
					tl.addRootTag(tag);
				} else {
					List<TagObject> tagList = tl.getRootTagList();
					for (Iterator<?> iterator2 = tagList.iterator(); iterator2.hasNext();) {
						TagObject tagObject = (TagObject) iterator2.next();
						if (tagObject instanceof EDIDataContainerModel) {
							if (fields[0].equals(((EDIDataContainerModel) tagObject).getSegCode())) {
								((EDIDataContainerModel) tagObject).setMultipe(true);
								break;
							}
						}
					}
				}
			}
			if (tag != null) {
				String ss = string.substring(fields[0].length(), string.length());
				generateChildrenTag(tag, ss, separators, 0);
			}
		}

		return tl;
	}

	private String getSeparator(String s) {
		if (s.equals("*") || s.equals("+") || s.equals("^")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return "\\" + s; //$NON-NLS-1$
		}
		return s;
	}

	private void generateChildrenTag(TagObject parent, String content, char[] separators, int currentSeparator) {
		char separator = separators[currentSeparator];
		String sss = new String(new char[] { separator });
		if (content.indexOf(sss) == -1)
			return;
		sss = getSeparator(sss);
		String[] contentArray = content.split(sss);
		if (contentArray == null || contentArray.length == 0) {
			return;
		}
		for (int i = 0; i < contentArray.length; i++) {
			String con = contentArray[i];
			if (con == null || con.length() == 0)
				continue;
			TagObject child = new TagObject();
			child.setName(con.trim());
			parent.addChildTag(child);
			int newIndex = (currentSeparator + 1);
			if (newIndex <= (separators.length - 1)) {
				generateChildrenTag(child, con, separators, newIndex);
			}
		}
	}
}
