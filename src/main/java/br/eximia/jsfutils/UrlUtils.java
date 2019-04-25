package br.eximia.jsfutils;

import java.util.Map;

import javax.faces.context.FacesContext;

public class UrlUtils {
	
	public static String getUrlParam(String param){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		return params.get(param);
	}
	
	public static Boolean getUrlParamAsBoolean(String param){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		return Boolean.valueOf(params.get(param));
	}

}
