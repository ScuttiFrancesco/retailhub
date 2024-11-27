package com.restweb.retailhub.config;

import com.restweb.retailhub.enums.TipoProdotto;
import jakarta.persistence.AttributeConverter;

public class TipoProdottoConverter implements AttributeConverter<TipoProdotto, String> {

	@Override
	public String convertToDatabaseColumn(TipoProdotto attribute) {

		if (attribute == null) {
			return null;
		}
		return attribute.toString();
	}

	@Override
	public TipoProdotto convertToEntityAttribute(String dbData) {

		if (dbData == null) {
			return null;
		}
		return TipoProdotto.valueOf(dbData);
	}

}
