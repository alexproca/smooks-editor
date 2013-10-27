/*******************************************************************************
 * Copyright (c) 2009 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.smooks.configuration.editors;

import java.util.HashMap;
import java.util.Map;

import org.jboss.tools.smooks.configuration.editors.csv12.Csv12ReaderBindingPropertyUICreator;
import org.jboss.tools.smooks.configuration.editors.csv12.Csv12ReaderMapBindingPropertyUICreator;
import org.jboss.tools.smooks.configuration.editors.csv12.Csv12ReaderUICreator;
import org.jboss.tools.smooks.configuration.editors.edireader12.EDIReader12UICreator;
import org.jboss.tools.smooks.configuration.editors.freemarker.FreemarkerUICreator;
import org.jboss.tools.smooks.configuration.editors.freemarker.InlineUICreator;
import org.jboss.tools.smooks.configuration.editors.freemarker.UseUICreator;
import org.jboss.tools.smooks.configuration.editors.javabean12.JavaBean12PropertyUICreator;
import org.jboss.tools.smooks.configuration.editors.javabean12.Javabean12ExpressionUICreator;
import org.jboss.tools.smooks.configuration.editors.javabean12.JavabeanValueBinding12UICreator;
import org.jboss.tools.smooks.configuration.editors.javabean12.JavabeanWiringBiding12UICreator;
import org.jboss.tools.smooks.configuration.editors.json12.Json12ReaderUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.ConditionTypeUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.ConditionsTypeUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.FeaturesTypeUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.HandlerTypeUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.HandlersTypeUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.ImportTypeUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.ParamTypeUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.ParamsTypeUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.ProfileTypeUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.ProfilesTypeUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.ReaderTypeUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.ResourceConfigTypeUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.ResourceTypeUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.SetOffTypeUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.SetOnTypeUICreator;
import org.jboss.tools.smooks.configuration.editors.smooks.SmooksResourceListTypeUICreator;
import org.jboss.tools.smooks.model.csv12.impl.BindingImpl;
import org.jboss.tools.smooks.model.csv12.impl.CSV12ReaderImpl;
import org.jboss.tools.smooks.model.csv12.impl.MapBindingImpl;
import org.jboss.tools.smooks.model.edi12.impl.EDI12ReaderImpl;
import org.jboss.tools.smooks.model.freemarker.impl.FreemarkerImpl;
import org.jboss.tools.smooks.model.freemarker.impl.InlineImpl;
import org.jboss.tools.smooks.model.freemarker.impl.UseImpl;
import org.jboss.tools.smooks.model.javabean12.impl.BeanTypeImpl;
import org.jboss.tools.smooks.model.json12.impl.Json12ReaderImpl;
import org.jboss.tools.smooks.model.smooks.impl.ConditionTypeImpl;
import org.jboss.tools.smooks.model.smooks.impl.ConditionsTypeImpl;
import org.jboss.tools.smooks.model.smooks.impl.FeaturesTypeImpl;
import org.jboss.tools.smooks.model.smooks.impl.HandlerTypeImpl;
import org.jboss.tools.smooks.model.smooks.impl.HandlersTypeImpl;
import org.jboss.tools.smooks.model.smooks.impl.ImportTypeImpl;
import org.jboss.tools.smooks.model.smooks.impl.ParamTypeImpl;
import org.jboss.tools.smooks.model.smooks.impl.ParamsTypeImpl;
import org.jboss.tools.smooks.model.smooks.impl.ProfileTypeImpl;
import org.jboss.tools.smooks.model.smooks.impl.ProfilesTypeImpl;
import org.jboss.tools.smooks.model.smooks.impl.ReaderTypeImpl;
import org.jboss.tools.smooks.model.smooks.impl.ResourceConfigTypeImpl;
import org.jboss.tools.smooks.model.smooks.impl.ResourceTypeImpl;
import org.jboss.tools.smooks.model.smooks.impl.SetOffTypeImpl;
import org.jboss.tools.smooks.model.smooks.impl.SetOnTypeImpl;
import org.jboss.tools.smooks.model.smooks.impl.SmooksResourceListTypeImpl;

/**
 * @author Dart (dpeng@redhat.com)
 *         <p>
 *         Apr 7, 2009
 */
public class PropertyUICreatorManager {
	private static PropertyUICreatorManager instance;

	private Map<Class<?>, IPropertyUICreator> map = null;

	private PropertyUICreatorManager() {
		map = new HashMap<Class<?>, IPropertyUICreator>();
		init();
	}

	private void init() {
		/*
		 * below if for smooks1.1
		 */
		// for javabean
//		map.put(BindingsTypeImpl.class, new BindingsPropertyUICreator());
//		map.put(ValueTypeImpl.class, new JavabeanValueUICreator());
//		map.put(WiringTypeImpl.class, new JavabeanWiringUICreator());
//		map.put(ExpressionTypeImpl.class, new JavabeanExpressionUICreator());

		// for smooks models
		map.put(ConditionTypeImpl.class, new ConditionTypeUICreator());
		map.put(ImportTypeImpl.class, new ImportTypeUICreator());
		map.put(ParamTypeImpl.class, new ParamTypeUICreator());
		map.put(ResourceConfigTypeImpl.class, new ResourceConfigTypeUICreator());
		map.put(ResourceTypeImpl.class, new ResourceTypeUICreator());
		map.put(ConditionsTypeImpl.class, new ConditionsTypeUICreator());
		map.put(FeaturesTypeImpl.class, new FeaturesTypeUICreator());
		map.put(HandlersTypeImpl.class, new HandlersTypeUICreator());
		map.put(HandlerTypeImpl.class, new HandlerTypeUICreator());
		map.put(ParamsTypeImpl.class, new ParamsTypeUICreator());
		map.put(ProfilesTypeImpl.class, new ProfilesTypeUICreator());
		map.put(ProfileTypeImpl.class, new ProfileTypeUICreator());
		map.put(ReaderTypeImpl.class, new ReaderTypeUICreator());
		map.put(SetOffTypeImpl.class, new SetOffTypeUICreator());
		map.put(SetOnTypeImpl.class, new SetOnTypeUICreator());
		map.put(SmooksResourceListTypeImpl.class, new SmooksResourceListTypeUICreator());

		// for freemarker
		map.put(org.jboss.tools.smooks.model.freemarker.impl.BindToImpl.class,
				new org.jboss.tools.smooks.configuration.editors.freemarker.BindToUICreator());
		map.put(FreemarkerImpl.class, new FreemarkerUICreator());
		map.put(InlineImpl.class, new InlineUICreator());
		map.put(org.jboss.tools.smooks.model.freemarker.impl.OutputToImpl.class,
				new org.jboss.tools.smooks.configuration.editors.freemarker.OutputToUICreator());
		map.put(org.jboss.tools.smooks.model.freemarker.impl.TemplateImpl.class,
				new org.jboss.tools.smooks.configuration.editors.freemarker.TemplateUICreator());
		map.put(UseImpl.class, new UseUICreator());

		
		// for JSON 1.2
		map.put(Json12ReaderImpl.class, new Json12ReaderUICreator());
		/*
		 * up is for smooks1.1
		 */

		/*
		 * bottom is for smooks 1.2
		 */
		
		// for JavaBean v1.2
		map.put(BeanTypeImpl.class, new JavaBean12PropertyUICreator());
		map
				.put(org.jboss.tools.smooks.model.javabean12.impl.ValueTypeImpl.class,
						new JavabeanValueBinding12UICreator());
		map.put(org.jboss.tools.smooks.model.javabean12.impl.ExpressionTypeImpl.class,
				new Javabean12ExpressionUICreator());
		map.put(org.jboss.tools.smooks.model.javabean12.impl.WiringTypeImpl.class,
				new JavabeanWiringBiding12UICreator());
		
		// for CSV Reader v1.2
		map.put(BindingImpl.class, new Csv12ReaderBindingPropertyUICreator());
		map.put(MapBindingImpl.class, new Csv12ReaderMapBindingPropertyUICreator());
		map.put(CSV12ReaderImpl.class, new Csv12ReaderUICreator());
		
		// for EDI Reader v1.2
		map.put(EDI12ReaderImpl.class, new EDIReader12UICreator());
	}

	public void registePropertyUICreator(Class<?> key, IPropertyUICreator creator) {
		map.put(key, creator);
	}

	public IPropertyUICreator getPropertyUICreator(Class<?> key) {
		return map.get(key);
	}

	public IPropertyUICreator getPropertyUICreator(Object model) {
		return map.get(model.getClass());
	}

	public static synchronized PropertyUICreatorManager getInstance() {
		if (instance == null) {
			instance = new PropertyUICreatorManager();
		}
		return instance;
	}
}
