package br.eximia.jsfutils;

import java.util.MissingResourceException;


public class BundleUtils {

	public static String getMessage(String key){
		try {
			return JsfUtils.getContext().getApplication().getResourceBundle(JsfUtils.getContext(), "bundleExceptions").getString(key);
		} catch (MissingResourceException e) {
			return "";
		}
		
	}

}
