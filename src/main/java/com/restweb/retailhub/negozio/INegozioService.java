package com.restweb.retailhub.negozio;

import com.restweb.retailhub.magazzino.MagazzinoDto;

import java.util.List;

public interface INegozioService {

	public NegozioDto inserisci(NegozioDto n);

	boolean aggiorna (NegozioDto n);

	boolean elimina (long id);

	NegozioDto getNegozioById(long id);

	List<NegozioDto> getListaNegozi();
	
}
