package com.moda.loja.tendencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moda.loja.tendencia.entities.Client;
import com.moda.loja.tendencia.services.ClientService;

@RestController
@RequestMapping(value = "/loja")
public class ClientController {

	@Autowired
	private ClientService service;
	
	@PostMapping(value = "/salvar-dados-do-cliente")
	public ResponseEntity<Object> salvarDadosDoCliente(@RequestBody Client client){
			
			service.salvarDadosDoCliente(client);
			return ResponseEntity.status(HttpStatus.CREATED).body("Parabéns, seus dados foram salvos com sucesso");
		
	}
}
