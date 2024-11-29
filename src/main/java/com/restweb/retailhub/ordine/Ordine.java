package com.restweb.retailhub.ordine;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import com.restweb.retailhub.cliente.Cliente;
import com.restweb.retailhub.enums.PagamentoOrdine;
import com.restweb.retailhub.enums.StatoOrdine;
import com.restweb.retailhub.negozio.Negozio;
import com.restweb.retailhub.operatore.Operatore;
import com.restweb.retailhub.prodotto.Prodotto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
	private Date dataOrdine;
	private StatoOrdine statoOrdine;
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
