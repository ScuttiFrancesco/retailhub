package com.restweb.retailhub.negozio;

import java.io.Serializable;
import java.util.List;
import com.restweb.retailhub.magazzino.Magazzino;
import com.restweb.retailhub.operatore.Operatore;
import com.restweb.retailhub.ordine.Ordine;

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
@Table(name = "negozi")
public class Negozio implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String sede;
	private String indirizzo;
	private String telefono;
	@OneToMany(mappedBy = "negozio")
	private List<Operatore> operatori;
	@OneToOne
	private Magazzino magazzino;
	@OneToMany(mappedBy = "negozio")
	private List<Ordine> ordini;

}