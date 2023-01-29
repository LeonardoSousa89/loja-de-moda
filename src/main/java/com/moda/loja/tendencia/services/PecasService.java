package com.moda.loja.tendencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moda.loja.tendencia.entities.Pecas;
import com.moda.loja.tendencia.repository.PecasRepository;
import com.moda.loja.tendencia.services.exceptions.ResourceNotFoundException;

@Service
public class PecasService {

	
	@Autowired
	private PecasRepository repository;
	
	
	public void insertItem(Pecas pecas) {
			
			repository.save(pecas);
	
	}
	
	
	public Page<Pecas> getItens(PageRequest pageRequest) {
		
			Page<Pecas> pecas = repository.findAll(pageRequest);
			
			if(pecas.isEmpty()) {
				
				throw new ResourceNotFoundException("Dados não encontrados");
				
			}
			
			return pecas;
	
	}
	
	
	public Pecas getItemById(long id){
			
			try {
				
				Pecas peca = repository.findById(id).get();
				
				return peca;
				
			}catch(Exception e) {
				
				throw new ResourceNotFoundException("Dados não encontrados");
				
			}
	
	}
	
	
	
	//BUSCAS POR QUERY PARAMS **
	
	public Page<Pecas> getItensBySearchCategory(String categoria, PageRequest pageRequest){
			
			Page<Pecas> pecas = repository.getItensBySearchCategory(categoria, pageRequest);
			
			if(pecas.isEmpty()) {
				
				throw new ResourceNotFoundException("Dados não encontrados");
				
			}
			
			return pecas;
		
	}
	
	
	public Page<Pecas> getItensBySearchDescribe(String descricao, PageRequest pageRequest){
		
			Page<Pecas> pecas = repository.getItensBySearchDescribe(descricao, pageRequest);
			
			if(pecas.isEmpty()) {
				
				throw new ResourceNotFoundException("Dados não encontrados");
				
			}
			
			return pecas;
		
	}
	
	
	public Page<Pecas> getItensBySearchSize(String tamanho, PageRequest pageRequest){
		
			Page<Pecas> pecas = repository.getItensBySearchSize(tamanho, pageRequest);
			
			if(pecas.isEmpty()) {
				
				throw new ResourceNotFoundException("Dados não encontrados");
				
			}
			
			return pecas;
	
	}
	
	
	public Page<Pecas> getItensBySearchColor(String cor, PageRequest pageRequest){
			
			Page<Pecas> pecas = repository.getItensBySearchColor(cor, pageRequest);
			
			if(pecas.isEmpty()) {
				
				throw new ResourceNotFoundException("Dados não encontrados");
				
			}
			
			return pecas;
		
	}
	
	
	public Page<Pecas> getItensBySearchPiece(String peca, PageRequest pageRequest){
		
			Page<Pecas> pecas = repository.getItensBySearchPiece(peca, pageRequest);
			
			if(pecas.isEmpty()) {
				
				throw new ResourceNotFoundException("Dados não encontrados");
				
			}
			
			return pecas;
	
	}
	
	//BUSCAS POR QUERY PARAMS **
	
	
	
	public void deleteAll(){
		
				repository.deleteAll();
	}
	
	
	public void deleteItem(long id){
		
			try {
			
				repository.deleteById(id);
				
			}catch (Exception e) {
				
				throw new ResourceNotFoundException("Dados não encontrados");
				
			}
		
	}

	
	private void updateData(Pecas newPeca, Pecas pecas) {
		
			newPeca.setPreco(pecas.getPreco());
			newPeca.setPeca(pecas.getPeca());
			newPeca.setCategoria(pecas.getCategoria());
			newPeca.setDescricao(pecas.getDescricao());
			newPeca.setTamanho(pecas.getTamanho());
			newPeca.setCor(pecas.getCor());
			newPeca.setImage_url(pecas.getImage_url());
			
	}
	
	
	public void updatePeca(Long id, Pecas peca) {
		
			try {
				
				Pecas newPeca = getItemById(id);
				
				updateData(newPeca, peca);
				
				repository.save(newPeca);
				
			}catch (Exception e) {
				
				throw new ResourceNotFoundException("Dados não encontrados");
				
				
			}
		
	}
	
	
}
