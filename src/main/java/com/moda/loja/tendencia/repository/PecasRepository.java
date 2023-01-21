package com.moda.loja.tendencia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moda.loja.tendencia.entities.Pecas;

@Repository
public interface PecasRepository extends JpaRepository<Pecas, Long>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM tendencia")
	Page<Pecas> getItens(org.springframework.data.domain.Pageable pageRequest); 
	
}
