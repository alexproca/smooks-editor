/**
 * JBoss, Home of Professional Open Source
 * Copyright 2009, JBoss Inc., and others contributors as indicated
 * by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 *
 * (C) 2009, JBoss Inc.
 */
package org.jboss.tools.smooks.launch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.jboss.tools.smooks.configuration.ProcessNodeType;
import org.jboss.tools.smooks.core.SmooksInputType;
import org.jboss.tools.smooks.launch.serialize.ObjectSerializer;
import org.milyn.Smooks;
import org.milyn.payload.JavaResult;
import org.milyn.payload.JavaSource;
import org.milyn.payload.StringResult;
import org.xml.sax.SAXException;

/**
 * Smooks runtime Launcher class.
 * 
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class SmooksLauncher {
	
	public static final String LOCALIZED_FILE_NAME = "localizedMessage.properties"; //$NON-NLS-1$

	/**
	 * Launcher Main.
	 * @param args Args.
	 */
	public static void main(String[] args) throws IOException, SAXException {
		Properties localizedMessages = loadLocalizedMessages();

		if(args.length != 4) {
			throw new RuntimeException(localizedMessages.getProperty("SmooksLauncher_Error_Expected_Four_Args")); //$NON-NLS-1$
		}
		Source inputSource = null;
		if(args[1].equals(SmooksInputType.INPUT_TYPE_JAVA)) {
			Class<?> clazz;
			try {
				clazz = Class.forName(args[2]);
				System.out.println(clazz);
				JavaGraphBuilder graphBuilder = new JavaGraphBuilder();
				
				Object objectGraph = graphBuilder.buildGraph(clazz);
				inputSource = new JavaSource(objectGraph);
			} catch (ClassNotFoundException e) {
				System.out.println("Class not found \n" + e.getLocalizedMessage());
			}
		} else {
			File input = new File(args[2]);
			assertFile(input, "Input"); //$NON-NLS-1$
			inputSource = new StreamSource(new FileInputStream(input)); 
		}	
		
		File smooksConfig = new File(args[0]);
		assertFile(smooksConfig, "Smooks"); //$NON-NLS-1$
		Smooks smooks = new Smooks(smooksConfig.toURI().getPath());
		try {
			Set<ProcessNodeType> processNodeTypes = SmooksLauncher.fromNodeTypeString(args[3]);
			JavaResult javaResult = new JavaResult();
			boolean nothingDisplayed = true;
			
			if(processNodeTypes.contains(ProcessNodeType.TEMPLATING)) {
				StringResult stringResult = new StringResult();
				
				smooks.filterSource(inputSource, stringResult, javaResult);
				System.out.println("[" + localizedMessages.getProperty("SmooksLauncher_Templating_To_StreamResult") + " ...]"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				System.out.println("    |--"); //$NON-NLS-1$
				System.out.println(indent(stringResult.toString()));
				System.out.println("    |--\n"); //$NON-NLS-1$
				nothingDisplayed = false;
			} else {
				smooks.filterSource(inputSource, javaResult);
			}
			System.out.println("successfully");
			Collection<ObjectSerializer> serializedJavaResults = ObjectSerializer.serialize(javaResult);
			if(!serializedJavaResults.isEmpty()) {
				System.out.println("[" + localizedMessages.getProperty("SmooksLauncher_Java_Mapping_Results") + "...]"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				
				for(ObjectSerializer serializedJavaResult : serializedJavaResults) {
					System.out.println("    |--"); //$NON-NLS-1$
					System.out.println(indent(serializedJavaResult.getSerializedForm()));
					System.out.println("    |--"); //$NON-NLS-1$
				}
				nothingDisplayed = false;
			}
			
			if(nothingDisplayed) {
				System.out.println(localizedMessages.getProperty("SmooksLauncher_Nothing_To_Display")); //$NON-NLS-1$
			}
		} finally {
			smooks.close();
		}
	}

	private static Properties loadLocalizedMessages() {
		Properties messages = new Properties();
		InputStream messageStream = SmooksLauncher.class.getResourceAsStream(LOCALIZED_FILE_NAME);
		
		try {
			try {
				messages.load(messageStream);
			} catch (IOException e) {
				System.out.println("Unexpected IOException reading classpath resource stream for '" + LOCALIZED_FILE_NAME + "'. " + e.getMessage()); //$NON-NLS-1$ //$NON-NLS-2$
				e.printStackTrace();
			}
		} finally {
			try {
				messageStream.close();
			} catch (IOException e) {
				System.out.println("Unexpected IOException closing classpath resource stream for '" + LOCALIZED_FILE_NAME + "'."); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		
		return messages;
	}

	private static void assertFile(File file, String name) {
		if(!file.exists()) {
			throw new RuntimeException("Specified '" + name + "' File '" + file.getAbsolutePath() + "' not found."); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		if(file.isDirectory()) {
			throw new RuntimeException("Specified '" + name + "' File '" + file.getAbsolutePath() + "' is a Directory."); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
	}

	public static Set<ProcessNodeType> fromNodeTypeString(String nodeTypeString) {
		String[] tokens = nodeTypeString.split(","); //$NON-NLS-1$
		Set<ProcessNodeType> nodeTypes = new HashSet<ProcessNodeType>();
		
		for(String token : tokens) {
			nodeTypes.add(ProcessNodeType.valueOf(token));
		}
		
		return nodeTypes;
	}

	private static String indent(String in) throws IOException {
		BufferedReader lineReader = new BufferedReader(new StringReader(in));
		StringBuilder indentBuf = new StringBuilder();
		
		String line = lineReader.readLine();
		while(line != null) {
			indentBuf.append("    |").append(line); //$NON-NLS-1$
			line = lineReader.readLine();
			if(line != null) {
				indentBuf.append('\n');
			}
		}
		
		return indentBuf.toString();
	}
}
