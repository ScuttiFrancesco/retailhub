package com.restweb.retailhub.magazzino;

import com.restweb.retailhub.negozio.NegozioDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MagazzinoDto {

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
