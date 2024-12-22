package com.restweb.retailhub.prodotto;

import java.util.List;

public interface IProdottoService {

    ProdottoDto inserisci(ProdottoDto p);

    boolean aggiorna(ProdottoDto p);

    boolean elimina(long id);

    ProdottoDto getProdottoById(long id);

    List<ProdottoDto> getListaProdotti();

    List<ProdottoDto> getListaProdottiByOrdine(long id);
}
