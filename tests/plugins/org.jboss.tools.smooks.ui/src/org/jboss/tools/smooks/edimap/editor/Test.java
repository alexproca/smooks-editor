/**
 * 
 */
package org.jboss.tools.smooks.edimap.editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jboss.tools.smooks.configuration.editors.xml.TagObject;


/**
 * @author Dart
 *
 */
public class Test {
	public static void main(String[] args) {
		try {
			new Test().test();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test() throws IOException {
		InputStream stream = Test.class.getResourceAsStream("input-message.edi"); //$NON-NLS-1$
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader br = new BufferedReader(reader);
		char segment = '\n';
		char field = '*';
		char component = '^';
		char subcomponent = '~';
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
		br.close();
		reader.close();
		stream.close();
		TagObject rootTag = new TagObject();
		rootTag.setName("root"); //$NON-NLS-1$
		List<String> names = new ArrayList<String>();
		char[] separators = new char[]{field,component,subcomponent};
		for (Iterator<?> iterator = segmentList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			String[] fields = string.split("\\" + new String(new char[] { field })); //$NON-NLS-1$
			TagObject tag = null;
			if (fields.length != 0) {
				tag = new TagObject();
				if (names.indexOf(fields[0]) == -1) {
					tag.setName(fields[0]);
					names.add(tag.getName());
					rootTag.addChildTag(tag);
				}
			}
			if (tag != null) {
				String ss = string.substring(fields[0].length() , string.length());
				generateChildrenTag(tag, ss, separators, 0);
			}
		}
//		
//		System.out.println(rootTag);
	}
	
	private String getSeparator(String s){
		if(s.equals("*") || s.equals("+") || s.equals("^")){ //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			return "\\" + s; //$NON-NLS-1$
		}
		return s;
	}

	private void generateChildrenTag(TagObject parent, String content, char[] separators, int currentSeparator) {
		char separator = separators[currentSeparator];
		String sss = new String(new char[] { separator });
		if(content.indexOf(sss) == -1) return;
		sss = getSeparator(sss);
		String[] contentArray = content.split(sss);
		if (contentArray == null || contentArray.length == 0) {
			return;
		}
		for (int i = 0; i < contentArray.length; i++) {
			String con = contentArray[i];
			if(con == null || con.length() == 0) continue;
			TagObject child = new TagObject();
			child.setName(con);
			parent.addChildTag(child);
			int newIndex = (currentSeparator+1);
			if (newIndex <= (separators.length - 1)) {
				generateChildrenTag(child, con, separators, newIndex);
			}
		}
	}
}
