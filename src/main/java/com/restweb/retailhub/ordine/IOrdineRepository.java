package com.restweb.retailhub.ordine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdineRepository extends JpaRepository<Ordine, Long> {

}
