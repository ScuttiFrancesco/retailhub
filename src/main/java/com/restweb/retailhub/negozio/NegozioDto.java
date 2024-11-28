package com.restweb.retailhub.negozio;

import com.restweb.retailhub.magazzino.Magazzino;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NegozioDto {

	private long id;
	@NotBlank
	private String sede;
	@NotBlank
	private String indirizzo;
	@NotBlank
	private String telefono;
	private Magazzino magazzino;

}