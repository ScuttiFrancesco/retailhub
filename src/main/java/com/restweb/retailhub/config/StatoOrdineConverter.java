package com.restweb.retailhub.config;

import com.restweb.retailhub.enums.PagamentoOrdine;
import com.restweb.retailhub.enums.StatoOrdine;

import jakarta.persistence.AttributeConverter;

public class StatoOrdineConverter implements AttributeConverter<StatoOrdine, String> {

	@Override
	public String convertToDatabaseColumn(StatoOrdine attribute) {

		if (attribute == null) {
			return null;
		}
		String eliminaUnderscore = attribute.toString().replace("_", " ");

		return eliminaUnderscore;
	}

	@Override
	public StatoOrdine convertToEntityAttribute(String dbData) {

		if (dbData == null) {
			return null;
		}
		String aggiungiUnderscore = dbData.replace(" ", "_");

		return StatoOrdine.valueOf(aggiungiUnderscore);
	}

}
