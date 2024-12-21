package com.restweb.retailhub.ordine;

import com.restweb.retailhub.enums.PagamentoOrdine;
import com.restweb.retailhub.enums.StatoOrdine;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface IOrdineRepository extends JpaRepository<Ordine, Long> {

    @Query(value = "SELECT o.id FROM ordini o ORDER BY o.id DESC LIMIT 1", nativeQuery = true)
    long recuperaUltimoId();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE ordini AUTO_INCREMENT = :id", nativeQuery = true )
    void setAutoIncrement(@Param("id") long id);

    List<Ordine> findAllByCliente_id(long id);

    List<Ordine> findAllByNegozio_id(long id);

    List<Ordine> findAllByDataOrdine(Date data);

    List<Ordine> findAllByStatoOrdine(StatoOrdine statoOrdine);

    List<Ordine> findAllByPagamentoOrdine(PagamentoOrdine pagamentoOrdine);
}
