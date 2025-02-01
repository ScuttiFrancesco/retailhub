package com.restweb.retailhub.prodotto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restweb.retailhub.enums.TipoProdotto;
import com.restweb.retailhub.magazzino.MagazzinoDto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.sql.Date;
import java.time.LocalDate;

@Data
public class ProdottoDto {

	private long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String marca;
	@NotBlank
	private String lotto;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Europe/Rome")
	private LocalDate dataScadenza;
	@DecimalMin(value = "1")
	private double prezzo;
	private TipoProdotto tipo;
	@Min(value = 1)
	private int quantita;
	private MagazzinoDto magazzino;

	public void trimCampi() {
		if (getNome() != null) {
			setNome(getNome().trim());
		}
		if (getMarca() != null) {
			setMarca(getMarca().trim());
		}
		if (getLotto() != null) {
			setLotto(getLotto().trim());
		}
	}
}
