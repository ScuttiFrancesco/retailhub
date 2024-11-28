package com.restweb.retailhub.magazzino;

import java.util.List;
import com.restweb.retailhub.negozio.Negozio;
import com.restweb.retailhub.prodotto.Prodotto;
import lombok.Data;

@Data
public class MagazzinoDto {

	private long id;
	private String sede;
	private String indirizzo;
	private String telefono;
	private Negozio negozio;
	private List<Prodotto> prodotti;

}
