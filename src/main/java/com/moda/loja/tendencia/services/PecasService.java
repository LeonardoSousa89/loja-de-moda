package com.moda.loja.tendencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moda.loja.tendencia.entities.Pecas;
import com.moda.loja.tendencia.repository.PecasRepository;
import com.sun.el.stream.Optional;

@Service
public class PecasService {

	@Autowired
	private PecasRepository repository;
	
	public Pecas insertItem(Pecas pecas) {
	
		return repository.save(pecas);
	
	}
	
	public Page<Pecas> getItens(PageRequest pageRequest) {
	
		Page<Pecas> pecas = repository.findAll(pageRequest);
		return pecas;
	
	}
	
	public java.util.Optional<Pecas> getItemById(long id){
	
		java.util.Optional<Pecas> peca = repository.findById(id);
		return peca;
	
	}
	
	public void deleteItem(long id){
		repository.deleteById(id);
	}
	
}
