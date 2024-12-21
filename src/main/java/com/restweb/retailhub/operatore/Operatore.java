package com.restweb.retailhub.operatore;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restweb.retailhub.negozio.Negozio;
import com.restweb.retailhub.ordine.Ordine;
import com.restweb.retailhub.persona.Persona;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "operatori")
public class Operatore extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Europe/Rome")
	private LocalDate dataAssunzione;
	private int livello;
	@OneToMany(mappedBy = "operatore")
	private List<Ordine> ordini;
	@ManyToOne
	private Negozio negozio;

}
