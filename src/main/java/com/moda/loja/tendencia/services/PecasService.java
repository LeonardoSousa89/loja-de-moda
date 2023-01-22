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
	
	
	public Pecas insertItem(Pecas pecas) {
		
		try {
			
			return repository.save(pecas);
			
		}catch (Exception e) {
			
			throw new ResourceBadRequestException("Desculpe, Houve um erro ao processar as informações");
			
		}
	
	}
	
	
	public Page<Pecas> getItens(PageRequest pageRequest) {
		
		try {
			
			Page<Pecas> pecas = repository.findAll(pageRequest);
			return pecas;
			
		}catch (Exception e) {
			
			throw new ResourceNotFoundException("Não há dados cadastrados");
		
		}
	
	}
	
	
	public Pecas getItemById(long id){
		
		try {
			
			Pecas peca = repository.findById(id).get();
			return peca;
			
		}catch (Exception e) {
			
			throw new ResourceNotFoundException("Dados não encontrados");
			
		}
	
	}
	
	
	public Page<Pecas> getItensBySearchSize(String tamanho, PageRequest pageRequest){
		
		try {
			
			Page<Pecas> pecas = repository.getItensBySearchSize(tamanho, pageRequest);
			return pecas;
		
		}catch (Exception e) {
			
			throw new ResourceNotFoundException("Dados não encontrados");
			
		}
		
	}
	
	
	public Page<Pecas> getItensBySearchColor(String cor, PageRequest pageRequest){
		
		try {
			
			Page<Pecas> pecas = repository.getItensBySearchColor(cor, pageRequest);
			return pecas;
			
		}catch (Exception e) {
			
			throw new ResourceNotFoundException("Dados não encontrados");
		
		}
		
	}
	
	
	public Page<Pecas> getItensBySearchColorAndSize(String cor, String tamanho, PageRequest pageRequest){
		
		try {
			
			Page<Pecas> pecas = repository.getItensBySearchColorAndSize(cor, tamanho, pageRequest);
			return pecas;
			
		}catch (Exception e) {
			
			throw new ResourceNotFoundException("Dados não encontrados");
		
		}
		
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
	
	
	public Pecas updatePeca(Long id, Pecas peca) {
		
		try {
			
			Pecas newPeca = getItemById(id);
			
			updateData(newPeca, peca);
			
			return repository.save(newPeca);
			
		}catch (Exception e) {
			
			throw new ResourceNotFoundException("Dados não encontrados");
			
			
		}
		
	}
	
	
}
