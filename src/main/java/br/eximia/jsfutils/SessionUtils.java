package br.eximia.jsfutils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {

	public static void setOnSession(String name, Object object) {
        ((HttpServletRequest) JsfUtils.getContext().getExternalContext().getRequest()).getSession().setAttribute(name, object);
    }

    public static Object getOnSession(String name) {
        return ((HttpServletRequest) JsfUtils.getContext().getExternalContext().getRequest()).getSession().getAttribute(name);
    }

}
