package com.moda.loja.tendencia.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

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

import com.moda.loja.tendencia.DTO.PecasDTO;
import com.moda.loja.tendencia.config.URL;
import com.moda.loja.tendencia.entities.Pecas;
import com.moda.loja.tendencia.services.PecasService;

@RestController
@RequestMapping(value = "/loja")
public class PecasController {

	
	@Autowired
	private PecasService service;
	
	private URL url;
	
	
	@PostMapping(value = "/inserir-item")
	public ResponseEntity<Object> insertItem(@RequestBody Pecas pecas){
			
			service.insertItem(pecas);
			
			return ResponseEntity.status(HttpStatus.CREATED).body("Item adicionado com sucesso");
		
	}
	
	
	@GetMapping(value = "/itens")
	public ResponseEntity<List<PecasDTO>> getItens(
			@RequestParam(value = "page",  required = false,  defaultValue = "0") int page, 
			@RequestParam(value = "size",  required = false, defaultValue = "12") int size
			) {
		
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Pecas> pecas = service.getItens(pageRequest);
		
		List<PecasDTO> pecasDTO =  pecas.stream().map(peca ->  new PecasDTO(peca)).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(pecasDTO);
		
	}
	
	
	@GetMapping(value = "/{id}/item")
	public ResponseEntity<PecasDTO> getItemById(@PathVariable long id) {
			
			Pecas peca = service.getItemById(id);
			
			PecasDTO pecasDTO = new PecasDTO(peca);
			
			return ResponseEntity.status(HttpStatus.OK).body(pecasDTO);
		
	}
	
	
	@GetMapping(value = "/item/tamanho/busca")
	public ResponseEntity<List<PecasDTO>> getItensBySearchSize(
			@RequestParam(value = "tamanho", required = true) String tamanho,
			@RequestParam(value = "page",    required = false,  defaultValue = "0")  int page
			) {
		
		PageRequest pageRequest = PageRequest.of(page, 100);
		Page<Pecas> pecas = service.getItensBySearchSize(tamanho, pageRequest);
		
		List<PecasDTO> pecasDTO = pecas.stream().map(peca -> new PecasDTO(peca)).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(pecasDTO);
		
	}
	
	
	@GetMapping(value = "/item/cor/busca")
	public ResponseEntity<List<PecasDTO>> getItensBySearchColor(
			@RequestParam(value = "cor", required = true) String cor,
			@RequestParam(value = "page",    required = false,  defaultValue = "0")  int page
			) {
		
		PageRequest pageRequest = PageRequest.of(page, 100);
		Page<Pecas> pecas = service.getItensBySearchColor(cor, pageRequest);
		
		List<PecasDTO> pecasDTO = pecas.stream().map(peca -> new PecasDTO(peca)).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(pecasDTO);
		
	}
	
	
	@GetMapping(value = "/item/cor-e-tamanho/busca")
	public ResponseEntity<List<PecasDTO>> getItensBySearchColorAndSize(
			@RequestParam(value = "cor", required = true) String cor,
			@RequestParam(value = "tamanho", required = true) String tamanho,
			@RequestParam(value = "page",    required = false,  defaultValue = "0")  int page
			) {
		
		PageRequest pageRequest = PageRequest.of(page, 100);
		Page<Pecas> pecas = service.getItensBySearchColorAndSize(cor, tamanho, pageRequest);
		
		List<PecasDTO> pecasDTO = pecas.stream().map(peca -> new PecasDTO(peca)).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(pecasDTO);
		
	}
	
	
	/*
	 * EX: 
	 * 		http://127.0.0.1:8766/loja/item/tipo/barra-de-busca/busca?tipo=Vestido%20de%20Linho&page=0
	 * 		http://127.0.0.1:8766/loja/item/tipo/barra-de-busca/busca?tipo=Vestido%20Fino&page=0
	 * */
	@GetMapping(value = "/item/tipo/barra-de-busca/busca")
	public ResponseEntity<List<PecasDTO>> getItensBySearchType(
			@RequestParam(value = "tipo", required = true) String tipo,
			@RequestParam(value = "page", required = false,  defaultValue = "0") int page
			) throws UnsupportedEncodingException {
			
			tipo = url.decodeParams(tipo);
			
			PageRequest pageRequest = PageRequest.of(page, 100);
			Page<Pecas> pecas = service.getItensBySearchType(tipo, pageRequest);
			
			List<PecasDTO> pecasDTO = pecas.stream().map(peca -> new PecasDTO(peca)).collect(Collectors.toList());
			
			return ResponseEntity.status(HttpStatus.OK).body(pecasDTO);
		
	}
	
	
	@DeleteMapping(value = "/deletar-todos-itens")
	public ResponseEntity<Object> deleteAll(){
		
		service.deleteAll();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	
	@DeleteMapping(value = "/{id}/deletar-item")
	public ResponseEntity<Object> deleteItem(@PathVariable long id){
		
		service.deleteItem(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	
	@PutMapping("/{id}/alterar-item")
	public ResponseEntity<Object> updatePeca(@PathVariable Long id,@RequestBody Pecas peca) {
		
		service.updatePeca(id, peca);
		return ResponseEntity.status(HttpStatus.CREATED).body("Item atualizado com sucesso");
		
	}
	
}
