package com.restweb.retailhub.operatore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface IOperatoreRepository extends JpaRepository<Operatore, Long> {

	@Query(value = "SELECT o.id FROM operatori o ORDER BY o.id DESC LIMIT 1", nativeQuery = true)
	long recuperaUltimoId();
	
	@Transactional
	@Modifying
	@Query(value = "ALTER TABLE operatori AUTO_INCREMENT = :id", nativeQuery = true)
	void setAutoIncrement(@Param("id") long id);
}
