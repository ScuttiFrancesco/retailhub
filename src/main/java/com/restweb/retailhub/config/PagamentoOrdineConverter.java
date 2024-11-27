package com.restweb.retailhub.config;

import com.restweb.retailhub.enums.PagamentoOrdine;
import jakarta.persistence.AttributeConverter;

public class PagamentoOrdineConverter implements AttributeConverter<PagamentoOrdine, String> {

	@Override
	public String convertToDatabaseColumn(PagamentoOrdine attribute) {

		if (attribute == null) {
			return null;
		}
		
		String eliminaUnderscore = attribute.toString().replace("_", " ");
		
		return eliminaUnderscore;
	}

	@Override
	public PagamentoOrdine convertToEntityAttribute(String dbData) {

		if (dbData == null) {
			return null;
		}
		
		String aggiungiUnderscore = dbData.replace(" ", "_");
		
		return PagamentoOrdine.valueOf(aggiungiUnderscore);
	}

}
