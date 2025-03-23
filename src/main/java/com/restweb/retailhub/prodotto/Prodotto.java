package com.restweb.retailhub.prodotto;

import com.restweb.retailhub.config.TipoProdottoConverter;
import com.restweb.retailhub.enums.TipoProdotto;
import com.restweb.retailhub.magazzino.Magazzino;
import com.restweb.retailhub.ordine.Ordine;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "prodotti")
public class Prodotto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String marca;
	private String lotto;
	private LocalDate dataScadenza;
	private double prezzo;
	private int quant;
	@Convert(converter = TipoProdottoConverter.class)
	private TipoProdotto tipo;
	private int quantita;
	@ManyToOne
	private Magazzino magazzino;
	@ManyToMany
	@JoinTable(name = "ordine_prodotto", joinColumns = @JoinColumn(name = "prodotto_id"), inverseJoinColumns = @JoinColumn(name = "ordine_id"))
	private List<Ordine> ordini;

}
