package br.eximia.jsfutils.converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("genericConverter")
public class GenericConverter implements Converter {
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private Map<String, Object> getViewMap(FacesContext context) {
    	Map<String, Object> viewMap = context.getViewRoot().getViewMap();
        Map<String, Object> idMap = (Map) viewMap.get(this.getClass().getName());
        if (idMap == null) {
            idMap = new HashMap<String, Object>();
            viewMap.put(this.getClass().getName(), idMap);
        }
        return idMap;
    }
   
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return getViewMap(context).get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
    	if(value == null || "".equals(value))
    		return "";
    	
        IdAsString asString = (IdAsString) value;
        getViewMap(context).put(asString.getIdAsString(), value);
        return asString.getIdAsString();
    }
   
}