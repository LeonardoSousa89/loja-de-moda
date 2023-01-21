package com.moda.loja.tendencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moda.loja.tendencia.entities.Pecas;
import com.moda.loja.tendencia.services.PecasService;

@RestController
@RequestMapping(value = "/loja")
public class PecasController {

	
	@Autowired
	private PecasService service;
	
	
	@PostMapping(value = "/inserir-item")
	public ResponseEntity<Object> insertItem(@RequestBody Pecas pecas){
		
		service.insertItem(pecas);
		return ResponseEntity.status(HttpStatus.CREATED).body("pecas inseridas com sucesso");
		
	}
	
	
	@GetMapping(value = "/itens")
	public ResponseEntity<Page<Pecas>> getItens(
			@RequestParam(value = "page",  required = false,  defaultValue = "0") int page, 
			@RequestParam(value = "size",  required = false, defaultValue = "6") int size
			){
		
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Pecas> pecas = service.getItens(pageRequest);
		return ResponseEntity.status(HttpStatus.OK).body(pecas);
		
	}
	
	
	@GetMapping(value = "/{id}/item")
	public ResponseEntity<Pecas> getItens(@PathVariable long id){
		
		Pecas peca = service.getItemById(id);
		return ResponseEntity.status(HttpStatus.OK).body(peca);
		
	}
	
	
	@DeleteMapping(value = "/{id}/deletar-item")
	public ResponseEntity<Object> deleteItem(@PathVariable long id){
		
		service.deleteItem(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	
	@PutMapping("/{id}/alterar-item")
	public ResponseEntity<Pecas> updatePeca(@PathVariable Long id,@RequestBody Pecas peca) {
		
		service.updatePeca(id, peca);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	
}
