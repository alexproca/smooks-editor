/*
 * JBoss, Home of Professional Open Source
 * Copyright 2006, JBoss Inc., and others contributors as indicated
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
 * (C) 2005-2006, JBoss Inc.
 */
package org.jboss.tools.smooks.configuration;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.milyn.Smooks;
import org.milyn.SmooksException;
import org.milyn.container.ExecutionContext;
import org.milyn.delivery.sax.SAXElement;
import org.milyn.delivery.sax.SAXVisitBefore;

/**
 * Smooks runtime dependency.
 * 
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class RuntimeDependency {
	
	/**
	 * Smooks runtime versions.
	 */
	public static enum SmooksVersion {
		v1_0,
		v1_1,
		v1_2,
		v1_3,
	}

	/**
	 * The Maven Artfact ID of the Smooks dependency.
	 */
	private String artifactId;
	/**
	 * The configuration namespace URI for the config..
	 */
	private URI namespaceURI;
	/**
	 * If the namepsaceURI is unsupported by the editor, this property can contain a change-to/upgrade/downgrade namepsace.
	 */
	private URI changeToNS;
	/**
	 * Whether or not the configuration is supported by the Editor.  Note that this property being 'false' is not the
	 * same as saying the config is not supported by the Smooks Runtime (see the 'runtimeVersions' property).
	 */
	private boolean supportedByEditor;
	/**
	 * The list of Smooks Runtimes that can support this configuration.  Note this does not mean
	 * the editor can support the configuration (see the 'supportedByEditor' property).
	 */
	private List<SmooksVersion> runtimeVersions;
	
	private static final String GROUP_ID = "org.milyn"; //$NON-NLS-1$
	private static final String META_INF = "META-INF"; //$NON-NLS-1$
	private static final String MILYN_SMOOKS_CORE = "milyn-smooks-core"; //$NON-NLS-1$
	private static final String MILYN_SMOOKS_CSV = "milyn-smooks-csv"; //$NON-NLS-1$
	private static final String MILYN_SMOOKS_EDI = "milyn-smooks-edi"; //$NON-NLS-1$
	private static final String MILYN_SMOOKS_JSON = "milyn-smooks-json"; //$NON-NLS-1$
	private static final String MILYN_SMOOKS_TEMPLATING = "milyn-smooks-templating"; //$NON-NLS-1$
	private static final String MILYN_SMOOKS_JAVABEAN = "milyn-smooks-javabean"; //$NON-NLS-1$
	private static final String MILYN_SMOOKS_FIXED_LENGTH = "milyn-smooks-fixed-length"; //$NON-NLS-1$
	private static final String MILYN_SMOOKS_CALC = "milyn-smooks-calc"; //$NON-NLS-1$
	private static final String MILYN_SMOOKS_PERSISTENCE = "milyn-smooks-persistence"; //$NON-NLS-1$
	private static final String MILYN_SMOOKS_ROUTING = "milyn-smooks-routing"; //$NON-NLS-1$
	private static final String MILYN_SMOOKS_RULES = "milyn-smooks-rules"; //$NON-NLS-1$
	private static final String MILYN_SMOOKS_SCRIPTING = "milyn-smooks-scripting"; //$NON-NLS-1$
	private static final String MILYN_SMOOKS_VALIDATION = "milyn-smooks-validation"; //$NON-NLS-1$
	
	private RuntimeDependency(String artifactId, URI namespaceURI, URI changeToNS, boolean supportedByEditor, List<SmooksVersion> runtimeVersions) {
		this.artifactId = artifactId;
		this.namespaceURI = namespaceURI;
		this.changeToNS = changeToNS;
		this.supportedByEditor = supportedByEditor;
	}
	
	public String getGroupId() {
		return GROUP_ID;
	}
	public String getArtifactId() {
		return artifactId;
	}	
	public URI getNamespaceURI() {
		return namespaceURI;
	}
	public URI getChangeToNS() {
		return changeToNS;
	}
	public boolean isSupportedByEditor() {
		return supportedByEditor;
	}
	public boolean isSupportedBySmooksVersion(SmooksVersion smooksVersion) {
		return runtimeVersions.contains(smooksVersion);
	}
	public boolean isOnProjectClasspath(ClassLoader projectClassloader) {
        String resourcePath = META_INF + namespaceURI.getPath();
		return (projectClassloader.getResource(resourcePath) != null);
	}
	
	public static void addDependencyChecklist(Smooks metadataExtractor) {
		// Add the supported feature dependency details...
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_CORE,       ProcessNodeType.BASE,         "smooks-1.1.xsd",            null, true, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list"); //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_CSV,        ProcessNodeType.INPUT_CSV,    "smooks/csv-1.2.xsd",        null, true, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/reader");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_EDI,        ProcessNodeType.INPUT_EDI,    "smooks/edi-1.2.xsd",        null, true, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/reader");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_JSON,       ProcessNodeType.INPUT_JSON,   "smooks/json-1.2.xsd",       null, true, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/reader");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_TEMPLATING, ProcessNodeType.TEMPLATING,   "smooks/freemarker-1.1.xsd", null, true, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/freemarker"); //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_JAVABEAN,   ProcessNodeType.JAVA_BINDING, "smooks/javabean-1.2.xsd",   null, true, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/bean");		 //$NON-NLS-1$ //$NON-NLS-2$

		// Add the unsupported feature dependency details...
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_CORE,         ProcessNodeType.BASE,         "smooks-1.0.xsd",              "smooks-1.1.xsd", false, SmooksVersion.v1_0, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_CSV,          ProcessNodeType.INPUT_CSV,    "smooks/csv-1.1.xsd",          "smooks/csv-1.2.xsd", false, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/reader");		 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_CSV,          ProcessNodeType.INPUT_CSV,    "smooks/csv-1.3.xsd",          "smooks/csv-1.2.xsd", false, SmooksVersion.v1_3), "/smooks-resource-list/reader");		 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_EDI,          ProcessNodeType.INPUT_EDI,    "smooks/edi-1.1.xsd",          "smooks/edi-1.2.xsd", false, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/reader");		 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_JSON,         ProcessNodeType.INPUT_JSON,   "smooks/json-1.1.xsd",         "smooks/json-1.2.xsd", false, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/reader");		 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_FIXED_LENGTH, ProcessNodeType.FIXED_LENGTH, "smooks/fixed-length-1.3.xsd", null, false, SmooksVersion.v1_3), "/smooks-resource-list/reader");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_CORE,         ProcessNodeType.DATASOURCE,   "smooks/datasource-1.1.xsd",   null, false, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/direct"); //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_CORE,         ProcessNodeType.DATASOURCE,   "smooks/datasource-1.1.xsd",   null, false, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/JNDI"); //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_CORE,         ProcessNodeType.DATASOURCE,   "smooks/datasource-1.3.xsd",   null, false, SmooksVersion.v1_3), "/smooks-resource-list/direct"); //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_CORE,         ProcessNodeType.DATASOURCE,   "smooks/datasource-1.3.xsd",   null, false, SmooksVersion.v1_3), "/smooks-resource-list/JNDI"); //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_CORE,         ProcessNodeType.CORE,         "smooks/core-1.3.xsd",         null, false, SmooksVersion.v1_3), "/smooks-resource-list/filterSettings"); //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_CORE,         ProcessNodeType.CORE,         "smooks/core-1.3.xsd",         null, false, SmooksVersion.v1_3), "/smooks-resource-list/namespaces"); //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_CORE,         ProcessNodeType.CORE,         "smooks/core-1.3.xsd",         null, false, SmooksVersion.v1_3), "/smooks-resource-list/terminate");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_TEMPLATING,   ProcessNodeType.TEMPLATING,   "smooks/xsl-1.1.xsd",          null, false, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/xsl"); //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_JAVABEAN,     ProcessNodeType.JAVA_BINDING, "smooks/javabean-1.1.xsd",     null, false, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/binding");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_JAVABEAN,     ProcessNodeType.JAVA_BINDING, "smooks/javabean-1.3.xsd",     null, false, SmooksVersion.v1_3), "/smooks-resource-list/bean"); //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_CALC,         ProcessNodeType.CALC,         "smooks/calc-1.1.xsd",         null, false, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/counter");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_PERSISTENCE,  ProcessNodeType.PERSISTENCE,  "smooks/persistence-1.2.xsd",  null, false, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/inserter");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_PERSISTENCE,  ProcessNodeType.PERSISTENCE,  "smooks/persistence-1.2.xsd",  null, false, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/updater"); //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_PERSISTENCE,  ProcessNodeType.PERSISTENCE,  "smooks/persistence-1.2.xsd",  null, false, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/deleter");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_PERSISTENCE,  ProcessNodeType.PERSISTENCE,  "smooks/persistence-1.2.xsd",  null, false, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/deleter");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_PERSISTENCE,  ProcessNodeType.PERSISTENCE,  "smooks/persistence-1.2.xsd",  null, false, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/flusher");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_PERSISTENCE,  ProcessNodeType.PERSISTENCE,  "smooks/persistence-1.2.xsd",  null, false, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/locator");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_ROUTING,      ProcessNodeType.ROUTING,      "smooks/db-routing-1.1.xsd",   null, false, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/executor"); //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_ROUTING,      ProcessNodeType.ROUTING,      "smooks/db-routing-1.1.xsd",   null, false, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/resultSetRowSelector");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_ROUTING,      ProcessNodeType.ROUTING,      "smooks/file-routing-1.1.xsd", null, false, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/outputStream");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_ROUTING,      ProcessNodeType.ROUTING,      "smooks/io-routing-1.1.xsd",   null, false, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/router");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_ROUTING,      ProcessNodeType.ROUTING,      "smooks/jms-routing-1.1.xsd",  null, false, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/router");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_ROUTING,      ProcessNodeType.ROUTING,      "smooks/jms-routing-1.2.xsd",  null, false, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/router");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_RULES,        ProcessNodeType.RULES,        "smooks/rules-1.0.xsd",        null, false, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/ruleBases");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_SCRIPTING,    ProcessNodeType.SCRIPTING,    "smooks/groovy-1.1.xsd",       null, false, SmooksVersion.v1_1, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/groovy");		 //$NON-NLS-1$ //$NON-NLS-2$
		metadataExtractor.addVisitor(new RuntimeDependencyTracker(MILYN_SMOOKS_VALIDATION,   ProcessNodeType.VALIDATION,   "smooks/validation-1.0.xsd",   null, false, SmooksVersion.v1_2, SmooksVersion.v1_3), "/smooks-resource-list/rule");		 //$NON-NLS-1$ //$NON-NLS-2$
	}

	private static class RuntimeDependencyTracker implements SAXVisitBefore {
		
		private String artifactId;
		private ProcessNodeType nodeType;
		private URI namespaceURI;
		private URI changeToNS;
		/**
		 * Whether or not the configuration is supported by the Editor.  Note that this property being 'false' is not the
		 * same as saying the config is not supported by the Smooks Runtime (see the 'runtimeVersions' property).
		 */
		private boolean supportedByEditor;
		/**
		 * The list of Smooks Runtimes that can support this configuration.  Note this does not mean
		 * the editor can support the configuration (see the 'supportedByEditor' property).
		 */
		private List<SmooksVersion> runtimeVersions = new ArrayList<SmooksVersion>();
		
		public RuntimeDependencyTracker(String artifactId, ProcessNodeType nodeType, String xsd, String changeToXSD, boolean supportedByEditor, SmooksVersion... runtimeVersions) {
			this.artifactId = artifactId;
			this.nodeType = nodeType;
			this.namespaceURI = URI.create("http://www.milyn.org/xsd/" + xsd); //$NON-NLS-1$
			if(changeToXSD != null) {
				this.changeToNS = URI.create("http://www.milyn.org/xsd/" + changeToXSD); //$NON-NLS-1$
			}
			this.supportedByEditor = supportedByEditor;
			if(runtimeVersions != null) {
				this.runtimeVersions.addAll(Arrays.asList(runtimeVersions));
			}
		}

		public void visitBefore(SAXElement configElement, ExecutionContext execContext) throws SmooksException, IOException {
			RuntimeMetadata metadata = (RuntimeMetadata) execContext.getAttribute(RuntimeMetadata.class);
			Set<URI> alreadyProcessed = (Set<URI>) execContext.getAttribute(RuntimeDependencyTracker.class);
			
			metadata.getNodeTypes().add(nodeType);
			
			if(alreadyProcessed == null) {
				alreadyProcessed = new HashSet<URI>();
				execContext.setAttribute(RuntimeDependencyTracker.class, alreadyProcessed);
			}
			
			// If the config namespace hasn't already been added, we need to add it...
			String configNS = configElement.getName().getNamespaceURI();
			if(configNS.equals(namespaceURI.toString()) && !alreadyProcessed.contains(namespaceURI)) {
				metadata.getDependencies().add(new RuntimeDependency(artifactId, namespaceURI, changeToNS, supportedByEditor, runtimeVersions));
				alreadyProcessed.add(namespaceURI);
			}
		}
	}
}
