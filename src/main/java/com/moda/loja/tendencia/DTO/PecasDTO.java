package com.moda.loja.tendencia.DTO;

import java.io.Serializable;

import com.moda.loja.tendencia.entities.Pecas;

public class PecasDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private double preco;
	private String peca;
	private String categoria;
	private String descricao;
	private String tamanho;
	private String cor;
	private String image_url;

	public PecasDTO() {}

	public PecasDTO(long id, double preco, String peca, String categoria, String descricao, String tamanho, String cor,
			String image_url) {
		this.id = id;
		this.preco = preco;
		this.peca = peca;
		this.categoria = categoria;
		this.descricao = descricao;
		this.tamanho = tamanho;
		this.cor = cor;
		this.image_url = image_url;
	}
	
	
	public PecasDTO(Pecas pecas) {
		this.id = pecas.getId();
		this.preco = pecas.getPreco();
		this.peca = pecas.getPeca();
		this.categoria = pecas.getCategoria();
		this.descricao = pecas.getDescricao();
		this.tamanho = pecas.getTamanho();
		this.cor = pecas.getCor();
		this.image_url = pecas.getImage_url();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getPeca() {
		return peca;
	}

	public void setPeca(String peca) {
		this.peca = peca;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
}
