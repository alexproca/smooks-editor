package org.jboss.tools.smooks.configuration.editors.input;

import java.util.ArrayList;
import java.util.List;

import org.jboss.tools.smooks.model.smooks.ParamType;

public class InputType {
	private String path;
	private String type;
	private boolean actived = false;
	
	private ParamType relatedParameter = null;

	private List<InputParameter> parameters = null;

	/**
	 * @return the parameters
	 */
	public List<InputParameter> getParameters() {
		if (parameters == null) {
			parameters = new ArrayList<InputParameter>();
		}
		return parameters;
	}
	

	/**
	 * @return the relatedParameter
	 */
	public ParamType getRelatedParameter() {
		return relatedParameter;
	}


	/**
	 * @param relatedParameter the relatedParameter to set
	 */
	public void setRelatedParameter(ParamType relatedParameter) {
		this.relatedParameter = relatedParameter;
	}



	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the actived
	 */
	public boolean isActived() {
		return actived;
	}

	/**
	 * @param actived
	 *            the actived to set
	 */
	public void setActived(boolean actived) {
		this.actived = actived;
	}

}
