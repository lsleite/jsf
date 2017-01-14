package com.lsl.util;

import javax.faces.context.FacesContext;

// TODO Write tests
public class JsfUtil {
	
	
	/**
	 * Shortcut for accessing context-param defined in the web.xml
	 * 
	 * @param paramName The context parameter name
	 * @return The context parameter value
	 */
	public static String getContextParam(String paramName){
		
		return FacesContext.getCurrentInstance().getExternalContext().getInitParameter(paramName);
		
	}

}
