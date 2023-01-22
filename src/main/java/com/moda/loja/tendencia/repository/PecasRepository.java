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
	
	
	@Query(nativeQuery = true, value = "SELECT id, preco, tipo, tamanho, cor, image_url FROM tendencia WHERE tamanho = (:tamanho)")
	Page<Pecas> getItensBySearchSize(String tamanho, org.springframework.data.domain.Pageable pageRequest);
	
	
	@Query(nativeQuery = true, value = "SELECT id, preco, tipo, tamanho, cor, image_url FROM tendencia WHERE cor = (:cor)")
	Page<Pecas> getItensBySearchColor(String cor, org.springframework.data.domain.Pageable pageRequest);
	
	
	@Query(nativeQuery = true, value = "SELECT id, preco, tipo, tamanho, cor, image_url FROM tendencia WHERE cor = (:cor) AND tamanho = (:tamanho)")
	Page<Pecas> getItensBySearchColorAndSize(String cor, String tamanho, org.springframework.data.domain.Pageable pageRequest);
	
}
