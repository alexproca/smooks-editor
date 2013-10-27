package org.jboss.tools.smooks.configuration.editors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public class Codegenerator {
	String basePath = "/home/DartPeng/Work/eclipse/smooks-configuration-workspace/org.jboss.tools.smooks.ui/src/org/jboss/tools/smooks/configuration/editors/uitls/temp/"; //$NON-NLS-1$
	String tempContents = ""; //$NON-NLS-1$

	public Codegenerator() {
		try {
			FileReader reader = new FileReader(
				new File(
					"/home/DartPeng/Work/eclipse/smooks-configuration-workspace/org.jboss.tools.smooks.ui/src/org/jboss/tools/smooks/configuration/editors/Template.txt")); //$NON-NLS-1$
			BufferedReader r = new BufferedReader(reader);
			String line = r.readLine();
			while (line != null) {
				tempContents += line;
				line = r.readLine();
				if (line != null) {
					tempContents += "\n"; //$NON-NLS-1$
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		Codegenerator g = new Codegenerator();
//		try {
//			g.generateCodes(DatasourcePackage.eINSTANCE);
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public void generateCodes(EPackage epackage) throws IllegalArgumentException,
		IllegalAccessException, IOException {
		Field[] fields = epackage.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			f.setAccessible(true);
			Class<?> clazz = f.getType();
			if (clazz == EClass.class) {
				EClass eClass = (EClass) f.get(epackage);
				if (eClass.isAbstract() || eClass.isInterface()) {
					continue;
				}
				File file = new File(basePath + eClass.getName() + "UICreator.java"); //$NON-NLS-1$
//				System.out.println("map.put(" + eClass.getName() + "Impl.class, new " //$NON-NLS-1$ //$NON-NLS-2$
//					+ eClass.getName() + "UICreator());"); //$NON-NLS-1$
				if (!file.exists()) {
					file.createNewFile();
					FileWriter writer = new FileWriter(file);
					writer.write(generateContents(eClass, epackage));
					writer.close();
				}
			}
		}
	}

	private String generateContents(EClass eClass, EPackage ePackage) {
		if (tempContents != null) {
			String className = eClass.getName() + "UICreator"; //$NON-NLS-1$
			String t = tempContents;
			if (t.indexOf("${className}") != -1) { //$NON-NLS-1$
				String s = t.substring(0, t.indexOf("${className}")); //$NON-NLS-1$
				String es = t.substring(t.indexOf("${className}") + "${className}".length(), t //$NON-NLS-1$ //$NON-NLS-2$
					.length());
				t = s + className + es;
			}
			String epName = ePackage.getClass().getSimpleName();
			if (epName.endsWith("Impl")) { //$NON-NLS-1$
				epName = epName.substring(0, epName.indexOf("Impl")); //$NON-NLS-1$
			}

			String allepName = epName + ".eINSTANCE.get" + eClass.getName(); //$NON-NLS-1$
			List<EAttribute> alist = eClass.getEAllAttributes();
			String attributeMethod = ""; //$NON-NLS-1$
			for (Iterator<?> iterator = alist.iterator(); iterator.hasNext();) {
				EAttribute attribute = (EAttribute) iterator.next();
				String atn = attribute.getName();
				String firstC = new String(new char[] { atn.toCharArray()[0] });
				firstC = firstC.toUpperCase();
				atn = firstC + atn.substring(1, atn.length());
				String n = allepName + "_" + atn + "()"; //$NON-NLS-1$ //$NON-NLS-2$
				String cn = "if(feature == " + n + "){}\n"; //$NON-NLS-1$ //$NON-NLS-2$
				attributeMethod += cn;
			}
			int index2 = t.indexOf("${attributeMethod}"); //$NON-NLS-1$
			if (index2 != -1) {
				String am1 = t.substring(0, index2);
				String am2 = t.substring(index2 + "${attributeMethod}".length(), t.length()); //$NON-NLS-1$
				t = am1 + attributeMethod + am2;
			}
			return t;
		}
		return ""; //$NON-NLS-1$
	}
}
