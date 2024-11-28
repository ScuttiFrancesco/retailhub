package com.restweb.retailhub.prodotto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdottoRepository extends JpaRepository<Prodotto, Long> {

}
