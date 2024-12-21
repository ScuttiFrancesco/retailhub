package com.restweb.retailhub.negozio;

import com.restweb.retailhub.magazzino.MagazzinoDto;
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


	public void trimCampi() {
		if (getSede() != null) {
			setSede(getSede().trim());
		}
		if (getIndirizzo() != null) {
			setIndirizzo(getIndirizzo().trim());
		}
		if (getTelefono() != null) {
			setTelefono(getTelefono().trim());
		}
	}
}