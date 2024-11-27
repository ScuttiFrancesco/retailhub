package com.restweb.retailhub.config;

import com.restweb.retailhub.enums.StatoOrdine;

import jakarta.persistence.AttributeConverter;

public class StatoOrdineConverter implements AttributeConverter<StatoOrdine, String> {

	@Override
	public String convertToDatabaseColumn(StatoOrdine attribute) {

		if (attribute == null) {
			return null;
		}
		return attribute.toString();
	}

	@Override
	public StatoOrdine convertToEntityAttribute(String dbData) {

		if (dbData == null) {
			return null;
		}
		return StatoOrdine.valueOf(dbData);
	}

}
