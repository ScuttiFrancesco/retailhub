package com.restweb.retailhub.magazzino;

import java.io.Serializable;
import java.util.List;
import com.restweb.retailhub.negozio.Negozio;
import com.restweb.retailhub.prodotto.Prodotto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "magazzini")
public class Magazzino implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String sede;
	private String indirizzo;
	private String telefono;
	@OneToOne
	private Negozio negozio;
	@OneToMany(mappedBy = "magazzino")
	private List<Prodotto> prodotti;

}
