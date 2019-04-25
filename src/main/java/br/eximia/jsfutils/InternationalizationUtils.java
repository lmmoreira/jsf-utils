package br.eximia.jsfutils;

import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;

import com.google.common.collect.Lists;

public class InternationalizationUtils {

	public static void setLocale(Locale locale){
		JsfUtils.getContext().getViewRoot().setLocale(locale);
    }
	
	public static Locale getLocale(){
		return JsfUtils.getContext().getViewRoot().getLocale();
	}
	
	public static List<Locale> getSupportedLocales(){
		return Lists.newArrayList(FacesContext.getCurrentInstance().getApplication().getSupportedLocales());
	}

}
