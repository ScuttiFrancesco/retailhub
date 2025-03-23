package com.restweb.retailhub.ordine;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.restweb.retailhub.cliente.ClienteDto;
import com.restweb.retailhub.enums.PagamentoOrdine;
import com.restweb.retailhub.enums.StatoOrdine;
import com.restweb.retailhub.negozio.NegozioDto;
import com.restweb.retailhub.operatore.OperatoreDto;
import com.restweb.retailhub.prodotto.ProdottoDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrdineDtoDaClient {

	private long id;
	private double totale;
	@NotNull(message = "Campo data ordine obbligatorio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Europe/Rome")
	private LocalDate dataOrdine;
	@NotNull
	private StatoOrdine statoOrdine;
	@NotNull
	private PagamentoOrdine pagamentoOrdine;
	private ClienteDto cliente;
	private OperatoreDto operatore;
	private NegozioDto negozio;
	@NotNull
	private List<ProdottoDto> prodotti;

	public void calcolaTotale(){

		this.totale = prodotti.stream().mapToDouble(p -> p.getPrezzo() * p.getQuantita()).sum();

	}

}
