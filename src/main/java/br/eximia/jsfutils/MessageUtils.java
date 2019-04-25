package br.eximia.jsfutils;

import javax.faces.application.FacesMessage;

public class MessageUtils {

    public static FacesMessage jsfMessage(FacesMessage.Severity severity, String message, String detail) {
    	FacesMessage facesMessage = new FacesMessage(severity, message, detail);
        JsfUtils.getContext().addMessage(null, facesMessage);
        return facesMessage;
    }

    public static FacesMessage jsfMessage(FacesMessage.Severity severity, String message) {
        return jsfMessage(severity, message, "");
    }

    public static FacesMessage jsfInfoMessage(String message) {
    	return jsfMessage(FacesMessage.SEVERITY_INFO, message);
    }
    
    public static FacesMessage jsfErrorMessage(String message) {
    	return jsfMessage(FacesMessage.SEVERITY_ERROR, message);
    }
    
    public static FacesMessage jsfWarnMessage(String message) {
    	return jsfMessage(FacesMessage.SEVERITY_WARN, message);
    }

}
