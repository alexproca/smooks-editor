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
package org.jboss.tools.smooks.templating.template;

import org.w3c.dom.Node;
import org.eclipse.core.runtime.Assert;

/**
 * Collection {@link ValueMapping}.
 * 
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class CollectionMapping extends Mapping {

    private String collectionItemName;

    /**
     * Public constructor.
     *
     * @param srcPath     Source path.
     * @param mappingNode The mapping node.
     */
    public CollectionMapping(String srcPath, Node mappingNode, String collectionItemName) {
        super(srcPath, mappingNode);
        Assert.isNotNull(collectionItemName, "collectionItemName"); //$NON-NLS-1$
        this.collectionItemName = collectionItemName;
    }

    public String getCollectionItemName() {
        return collectionItemName;
    }
}
