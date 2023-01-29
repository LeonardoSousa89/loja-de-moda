package com.moda.loja.tendencia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moda.loja.tendencia.entities.Pecas;

@Repository
public interface PecasRepository extends JpaRepository<Pecas, Long>{
	
	//BUSCA AO CARREGAR A PÁGINA
	
	//quando carregar o card de itens
	@Query(nativeQuery = true, value = "SELECT * FROM tendencia")
	Page<Pecas> getItens(org.springframework.data.domain.Pageable pageRequest); 
	
	
	//BUSCA NO CHECK-BOX
	
	//farei a busca pelo preço nesta faixa
	
	@Query(nativeQuery = true, value = "SELECT id, preco, peca, categoria, descricao, tamanho, cor, image_url FROM tendencia WHERE categoria = (:categoria)")
	Page<Pecas> getItensBySearchCategory(String categoria, org.springframework.data.domain.Pageable pageRequest);
	
	
	@Query(nativeQuery = true, value = "SELECT id, preco, peca, categoria, descricao, tamanho, cor, image_url FROM tendencia WHERE descricao = (:descricao)")
	Page<Pecas> getItensBySearchDescribe(String descricao, org.springframework.data.domain.Pageable pageRequest);
	
	
	@Query(nativeQuery = true, value = "SELECT id, preco, peca, categoria, descricao, tamanho, cor, image_url FROM tendencia WHERE tamanho = (:tamanho)")
	Page<Pecas> getItensBySearchSize(String tamanho, org.springframework.data.domain.Pageable pageRequest);
	
	
	@Query(nativeQuery = true, value = "SELECT id, preco, peca, categoria, descricao, tamanho, cor, image_url FROM tendencia WHERE cor = (:cor)")
	Page<Pecas> getItensBySearchColor(String cor, org.springframework.data.domain.Pageable pageRequest);
	
	
	
	//BUSCA NA BARRA DE PESQUISA
	
	@Query(nativeQuery = true, value = "SELECT id, preco, peca, categoria, descricao, tamanho, cor, image_url FROM tendencia WHERE peca = (:peca)")
	Page<Pecas> getItensBySearchPiece(String peca, org.springframework.data.domain.Pageable pageRequest);
	
}
