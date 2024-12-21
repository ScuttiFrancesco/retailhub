package com.restweb.retailhub.negozio;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface INegozioRepository extends JpaRepository<Negozio, Long> {

    @Query(value = "SELECT n.id FROM negozi n ORDER BY n.id DESC LIMIT 1", nativeQuery = true)
    long recuperaUltimoId();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE negozi AUTO_INCREMENT = :id", nativeQuery = true )
    void setAutoIncrement(@Param("id") long id);
}
