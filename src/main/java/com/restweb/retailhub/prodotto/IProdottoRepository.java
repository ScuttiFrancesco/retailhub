package com.restweb.retailhub.prodotto;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProdottoRepository extends JpaRepository<Prodotto, Long> {

    @Query(value = "SELECT p.id FROM prodotti p ORDER BY p.id DESC  LIMIT 1", nativeQuery = true)
    Long recuperaUltimoId();

    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE clienti AUTO_INCREMENT = :id", nativeQuery = true)
    void setAutoincrement(@Param("id") long id);

    @Query(value = "SELECT p.id, p.data_scadenza, p.lotto, p.marca, p.nome, p.prezzo, p.quantita, p.tipo, p.magazzino_id, op.prodotto_id, op.ordine_id FROM prodotti p JOIN ordine_prodotto op ON p.id = op.prodotto_id JOIN ordini o ON o.id = op.ordine_id WHERE op.ordine_id = :id", nativeQuery = true)
    List<Prodotto> findAllByOrdine_id(@Param("id")long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE prodotti p SET p.quantita = p.quantita + :quantita WHERE p.nome = :nome AND p.marca = :marca", nativeQuery = true)
    void modificaQuantita(@Param("nome") String nome, @Param("marca") String marca, @Param("quantita") long quantita);

    Prodotto findByNomeAndMarca(String nome, String marca);
}
