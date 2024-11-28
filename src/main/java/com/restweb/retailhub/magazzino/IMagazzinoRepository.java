package com.restweb.retailhub.magazzino;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMagazzinoRepository extends JpaRepository<Magazzino, Long> {

}
