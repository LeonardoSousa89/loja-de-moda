package com.moda.loja.tendencia.DTO;

import java.io.Serializable;

import com.moda.loja.tendencia.entities.Pecas;

public class PecasDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private double preco;
	private String tipo;
	private String tamanho;
	private String cor;
	private String image_url;

	public PecasDTO() {}
	
	public PecasDTO(Pecas peca) {
		this.id = peca.getId();
		this.preco = peca.getPreco();
		this.tipo = peca.getTipo();
		this.tamanho = peca.getTamanho();
		this.cor = peca.getCor();
		this.image_url = peca.getImage_url();
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
