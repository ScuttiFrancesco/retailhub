package com.restweb.retailhub.magazzino;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface IMagazzinoRepository extends JpaRepository<Magazzino, Long> {
	
	@Query(value = "SELECT m.id FROM magazzini m ORDER BY m.id DESC LIMIT 1", nativeQuery = true)
	long recuperaUltimoId();
	
	@Transactional
	@Modifying
	@Query(value = "ALTER TABLE magazzini AUTO_INCREMENT = :id", nativeQuery = true )
	void setAutoIncrement(@Param("id") long id);
	
}
