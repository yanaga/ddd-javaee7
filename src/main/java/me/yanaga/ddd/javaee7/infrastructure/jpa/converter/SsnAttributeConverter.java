package me.yanaga.ddd.javaee7.infrastructure.jpa.converter;

import me.yanaga.ddd.javaee7.domain.model.Ssn;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SsnAttributeConverter implements AttributeConverter<Ssn, String> {
	@Override
	public String convertToDatabaseColumn(Ssn ssn) {
		if (ssn != null) {
			return ssn.toString();
		}
		return null;
	}

	@Override
	public Ssn convertToEntityAttribute(String s) {
		if (s != null) {
			return Ssn.of(s);
		}
		return null;
	}
}
