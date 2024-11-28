package com.restweb.retailhub.operatore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOperatoreRepository extends JpaRepository<Operatore, Long> {

}
