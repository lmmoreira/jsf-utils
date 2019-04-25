package br.eximia.jsfutils;

import javax.faces.context.FacesContext;

public class JsfUtils {

    public static FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }
   
}
