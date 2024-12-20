package com.restweb.retailhub.prodotto;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdottoRepository extends JpaRepository<Prodotto, Long> {

    @Query(value = "SELECT p.id FROM prodotti p ORDER BY p.id DESC  LIMIT 1", nativeQuery = true)
    Long recuperaUltimoId();

    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE clienti AUTO_INCREMENT = :id", nativeQuery = true)
    void setAutoincrement(@Param("id") long id);
}
