package com.restweb.retailhub.magazzino;

import com.restweb.retailhub.negozio.Negozio;
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
	private Negozio negozio;// da verificare se crea il loop...ev. si puo eliminare

}
