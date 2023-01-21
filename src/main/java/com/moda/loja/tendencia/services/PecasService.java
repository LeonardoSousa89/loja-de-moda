package com.moda.loja.tendencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moda.loja.tendencia.entities.Pecas;
import com.moda.loja.tendencia.repository.PecasRepository;

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
	
	
	public Pecas getItemById(long id){
	
		Pecas peca = repository.findById(id).get();
		return peca;
	
	}
	
	
	public void deleteItem(long id){
		repository.deleteById(id);
	}
	

	private void updateData(Pecas newPeca, Pecas peca) {
		
		newPeca.setPreco(peca.getPreco());
		newPeca.setTipo(peca.getTipo());
		newPeca.setTamanho(peca.getTamanho());
		newPeca.setCor(peca.getCor());
		newPeca.setImage_url(peca.getImage_url());
			
	}
	
	
	public Pecas updatePeca(Long id, Pecas peca) {
		
		Pecas newPeca = getItemById(id);
		
		updateData(newPeca, peca);
		
		return repository.save(newPeca);
	
	}
	
	
}
