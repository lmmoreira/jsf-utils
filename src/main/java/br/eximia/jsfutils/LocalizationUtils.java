package br.eximia.jsfutils;

import java.io.IOException;

import br.eximia.jsfutils.exception.RedirectingException;

public class LocalizationUtils {

	public static void redirect(String url) {
        try {
            JsfUtils.getContext().getExternalContext().redirect(url);
        } catch (IOException ex) {
            throw new RedirectingException(ex);
        }
    }

}
