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
	
	
	
	//BUSCAS POR QUERY PARAMS **
	
	/*
	 * EX: 
	 * 		http://127.0.0.1:8766/loja/item/categoria/busca?categoria=moda%20feminina&page=0
	 * */
	
	@GetMapping(value = "/item/checkbox/categoria/busca")
	public ResponseEntity<List<PecasDTO>> getItensBySearchCategory(
			@RequestParam(value = "categoria", required = true) String categoria,
			@RequestParam(value = "page",      required = false,  defaultValue = "0")  int page
			) throws UnsupportedEncodingException {
		
		categoria = url.decodeParams(categoria);
		
		PageRequest pageRequest = PageRequest.of(page, 100);
		Page<Pecas> pecas = service.getItensBySearchCategory(categoria, pageRequest);
		
		List<PecasDTO> pecasDTO = pecas.stream().map(peca -> new PecasDTO(peca)).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(pecasDTO);
		
	}
	
	
	/*
	 * EX: 
	 * 		http://127.0.0.1:8766/loja/item/descricao/busca?descricao=vestido%20de%20linho&page=0
	 * 		http://127.0.0.1:8766/loja/item/descricao/busca?descricao=vestido%20fino&page=0
	 * */
	
	@GetMapping(value = "/item/checkbox/descricao/busca")
	public ResponseEntity<List<PecasDTO>> getItensBySearchDescribe(
			@RequestParam(value = "descricao", required = true) String descricao,
			@RequestParam(value = "page", required = false,  defaultValue = "0") int page
			) throws UnsupportedEncodingException {
			
			descricao = url.decodeParams(descricao);
			
			PageRequest pageRequest = PageRequest.of(page, 100);
			Page<Pecas> pecas = service.getItensBySearchDescribe(descricao, pageRequest);
			
			List<PecasDTO> pecasDTO = pecas.stream().map(peca -> new PecasDTO(peca)).collect(Collectors.toList());
			
			return ResponseEntity.status(HttpStatus.OK).body(pecasDTO);
		
	}
	
	
	@GetMapping(value = "/item/checkbox/tamanho/busca")
	public ResponseEntity<List<PecasDTO>> getItensBySearchSize(
			@RequestParam(value = "tamanho", required = true) String tamanho,
			@RequestParam(value = "page",    required = false,  defaultValue = "0")  int page
			) {
		
		PageRequest pageRequest = PageRequest.of(page, 100);
		Page<Pecas> pecas = service.getItensBySearchSize(tamanho, pageRequest);
		
		List<PecasDTO> pecasDTO = pecas.stream().map(peca -> new PecasDTO(peca)).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(pecasDTO);
		
	}
	
	
	@GetMapping(value = "/item/checkbox/cor/busca")
	public ResponseEntity<List<PecasDTO>> getItensBySearchColor(
			@RequestParam(value = "cor", required = true) String cor,
			@RequestParam(value = "page",    required = false,  defaultValue = "0")  int page
			) {
		
		PageRequest pageRequest = PageRequest.of(page, 100);
		Page<Pecas> pecas = service.getItensBySearchColor(cor, pageRequest);
		
		List<PecasDTO> pecasDTO = pecas.stream().map(peca -> new PecasDTO(peca)).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(pecasDTO);
		
	}
	
	
	@GetMapping(value = "/item/barra-de-busca/peca/busca")
	public ResponseEntity<List<PecasDTO>> getItensBySearchPiece(
			@RequestParam(value = "peca", required = true) String peca,
			@RequestParam(value = "page",    required = false,  defaultValue = "0")  int page
			) {
		
		PageRequest pageRequest = PageRequest.of(page, 100);
		Page<Pecas> pecas = service.getItensBySearchPiece(peca, pageRequest);
		
		List<PecasDTO> pecasDTO = pecas.stream().map(pecaDto -> new PecasDTO(pecaDto)).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(pecasDTO);
		
	}
	
	//BUSCAS POR QUERY PARAMS **
	
	
	
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
