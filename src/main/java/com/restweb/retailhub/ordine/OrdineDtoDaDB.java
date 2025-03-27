package com.restweb.retailhub.ordine;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.restweb.retailhub.cliente.ClienteDto;
import com.restweb.retailhub.config.FlexibleInstantDeserializer;
import com.restweb.retailhub.enums.PagamentoOrdine;
import com.restweb.retailhub.enums.StatoOrdine;
import com.restweb.retailhub.negozio.NegozioDto;
import com.restweb.retailhub.operatore.OperatoreDto;
import lombok.Data;

@Data
public class OrdineDtoDaDB {

	private long id;
	private double totale;
	@JsonDeserialize(using = FlexibleInstantDeserializer.class)
	private Instant dataOrdine;
	private StatoOrdine statoOrdine;
	private PagamentoOrdine pagamentoOrdine;
	private ClienteDto cliente;
	private OperatoreDto operatore;
	private NegozioDto negozio;
	

}
