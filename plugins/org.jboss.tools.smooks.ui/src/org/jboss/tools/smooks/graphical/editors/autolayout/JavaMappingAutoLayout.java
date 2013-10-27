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
package org.jboss.tools.smooks.graphical.editors.autolayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.graph.DirectedGraph;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.draw2d.graph.NodeList;
import org.jboss.tools.smooks.graphical.editors.editparts.InputDataContainerEditPart;
import org.jboss.tools.smooks.graphical.editors.editparts.javamapping.JavaBeanEditPart;

/**
 * @author Dart
 *
 */
public class JavaMappingAutoLayout implements IAutoLayout{
	
	private  int INPUT_JAVA_WIDTH = 200;
	
	private  int SPACE_JAVA = 20;
	
	private  int INIT_X = 50;
	
	private  int INIT_Y = 50;
	
	public void visit(DirectedGraph graph){
		NodeList nodeList = graph.nodes;
		// place the java-mapping nodes;
		int javaHeight = 0;
		Node inputNode = null;
		int java_y = INIT_Y;
		List<Node> javaNodes = new ArrayList<Node>();
		for (Iterator<?> iterator = nodeList.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			Object data = node.data;
			if(data instanceof JavaBeanEditPart){
				javaHeight = javaHeight + SPACE_JAVA + node.height;
				node.y = java_y;
				java_y = java_y + SPACE_JAVA + node.height;
				javaNodes.add(node);
			}
			if(data instanceof InputDataContainerEditPart){
				inputNode = node;
			}
		}
		javaHeight = javaHeight - INIT_Y;
		int java_x = INIT_X;
		if(inputNode != null){
			inputNode.x = INIT_X;
			int input_y = INIT_Y;
			if(javaHeight > inputNode.height){
				int cha = (javaHeight - inputNode.height)/2;
				input_y =  cha;
			}
			inputNode.y = input_y;
			java_x = inputNode.x + inputNode.width + INPUT_JAVA_WIDTH;
		}
		
		for (Iterator<?> iterator = javaNodes.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			node.x = java_x;
		}
		
	}
}
