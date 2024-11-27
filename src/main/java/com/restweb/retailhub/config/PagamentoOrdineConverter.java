package com.restweb.retailhub.config;

import com.restweb.retailhub.enums.PagamentoOrdine;
import jakarta.persistence.AttributeConverter;

public class PagamentoOrdineConverter implements AttributeConverter<PagamentoOrdine, String> {

	@Override
	public String convertToDatabaseColumn(PagamentoOrdine attribute) {

		if (attribute == null) {
			return null;
		}
		return attribute.toString();
	}

	@Override
	public PagamentoOrdine convertToEntityAttribute(String dbData) {

		if (dbData == null) {
			return null;
		}
		return PagamentoOrdine.valueOf(dbData);
	}

}
