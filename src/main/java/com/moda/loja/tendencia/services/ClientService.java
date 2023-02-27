package com.moda.loja.tendencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moda.loja.tendencia.entities.Client;
import com.moda.loja.tendencia.repository.ClientRepository;
import com.moda.loja.tendencia.services.exceptions.ResourceBadRequestException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public void salvarDadosDoCliente(Client client) {
		try {
			repository.save(client); 
		}catch (Exception e) {
			throw new ResourceBadRequestException("Desculpe, houve um erro, verifique se o email já está cadastrado, se é válido ou se o campo email está vazio");
		}
		
	}
	
}
