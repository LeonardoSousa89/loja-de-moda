package com.moda.loja.tendencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moda.loja.tendencia.entities.Pecas;
import com.moda.loja.tendencia.repository.PecasRepository;
import com.moda.loja.tendencia.services.exceptions.ResourceBadRequestException;
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
	
	
	public Page<Pecas> getItensBySearchColorAndSize(String cor, String tamanho, PageRequest pageRequest){
			
			Page<Pecas> pecas = repository.getItensBySearchColorAndSize(cor, tamanho, pageRequest);
			
			if(pecas.isEmpty()) {
				
				throw new ResourceNotFoundException("Dados não encontrados");
				
			}
			
			return pecas;
		
	}
	
	
	public Page<Pecas> getItensBySearchType(String tipo, PageRequest pageRequest){
			
			Page<Pecas> pecas = repository.getItensBySearchType(tipo, pageRequest);
			
			if(pecas.isEmpty()) {
				
				throw new ResourceNotFoundException("Dados não encontrados");
				
			}
			
			return pecas;
			
	}
	
	
	public void deleteAll(){
		
		try {
			
			repository.deleteAll();
			
		}catch (Exception e) {
			
			throw new ResourceBadRequestException("Desculpe, Ocorreu um erro não previsto");
			
		}
		
	}
	
	
	public void deleteItem(long id){
		
		try {
		
			repository.deleteById(id);
			
		}catch (Exception e) {
			
			throw new ResourceNotFoundException("Dados não encontrados");
			
		}
		
	}

	
	private void updateData(Pecas newPeca, Pecas peca) {
		
		newPeca.setPreco(peca.getPreco());
		newPeca.setTipo(peca.getTipo());
		newPeca.setTamanho(peca.getTamanho());
		newPeca.setCor(peca.getCor());
		newPeca.setImage_url(peca.getImage_url());
			
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
