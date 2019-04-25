package br.eximia.jsfutils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	
	public static void submitCookie(String key, String value) {
		Map<String, String> cookie = new HashMap<String, String>();
		cookie.put(key, value);
		submitCookies(cookie);
	}

	public static void submitCookies(Map<String, String> cookies) {
	    HttpServletResponse httpServletResponse = (HttpServletResponse) JsfUtils.getContext().getExternalContext().getResponse();
	    Set<String> keys = cookies.keySet();
	    
	    for (String cookie : keys) {
	        Cookie oCookie = new Cookie(cookie, cookies.get(cookie));
	        oCookie.setMaxAge(2592000);
	        httpServletResponse.addCookie(oCookie);
	    }
	}

    public static String getCookie(String cookie) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) JsfUtils.getContext().getExternalContext().getRequest();
        Cookie[] cookies = httpServletRequest.getCookies();
        
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equalsIgnoreCase(cookie)) {
                    return cookies[i].getValue();
                }
            }
        }

        return "";
    }

}
