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
	
	public PecasDTO(long id, double preco, String tipo, String tamanho, String cor, String image_url) {
		this.id = id;
		this.preco = preco;
		this.tipo = tipo;
		this.tamanho = tamanho;
		this.cor = cor;
		this.image_url = image_url;
	}

	public PecasDTO(Pecas peca) {
		id = peca.getId();
		preco = peca.getPreco();
		tipo = peca.getTipo();
		tamanho = peca.getTamanho();
		cor = peca.getCor();
		image_url = peca.getImage_url();
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
