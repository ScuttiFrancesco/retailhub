package com.restweb.retailhub.negozio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INegozioRepository extends JpaRepository<Negozio, Long> {

}
