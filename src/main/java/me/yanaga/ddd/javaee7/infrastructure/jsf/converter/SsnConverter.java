package me.yanaga.ddd.javaee7.infrastructure.jsf.converter;

import me.yanaga.ddd.javaee7.domain.model.Ssn;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Ssn.class)
public class SsnConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
		if (s != null) {
			try {
				return Ssn.of(s);
			}
			catch (Exception e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid SSN", null));
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
		if (o != null) {
			return o.toString();
		}
		return null;
	}
}
