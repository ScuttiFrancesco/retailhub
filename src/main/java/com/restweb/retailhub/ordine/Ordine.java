package com.restweb.retailhub.ordine;

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.restweb.retailhub.cliente.Cliente;
import com.restweb.retailhub.config.FlexibleInstantDeserializer;
import com.restweb.retailhub.config.PagamentoOrdineConverter;
import com.restweb.retailhub.config.StatoOrdineConverter;
import com.restweb.retailhub.config.TipoProdottoConverter;
import com.restweb.retailhub.enums.PagamentoOrdine;
import com.restweb.retailhub.enums.StatoOrdine;
import com.restweb.retailhub.negozio.Negozio;
import com.restweb.retailhub.operatore.Operatore;
import com.restweb.retailhub.prodotto.Prodotto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ordini")
public class Ordine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double totale;
	@JsonDeserialize(using = FlexibleInstantDeserializer.class)
	private Instant dataOrdine;
	@Convert(converter = StatoOrdineConverter.class)
	private StatoOrdine statoOrdine;
	@Convert(converter = PagamentoOrdineConverter.class)
	private PagamentoOrdine pagamentoOrdine;
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Operatore operatore;
	@ManyToOne
	private Negozio negozio;
	@ManyToMany
	@JoinTable(name = "ordine_prodotto", joinColumns = @JoinColumn(name = "ordine_id"), inverseJoinColumns = @JoinColumn(name = "prodotto_id"))
	private List<Prodotto> prodotti;

}
