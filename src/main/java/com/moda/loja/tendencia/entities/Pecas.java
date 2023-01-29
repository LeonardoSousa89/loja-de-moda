package com.moda.loja.tendencia.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity
@Table(name = "tendencia")
public class Pecas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double preco;
	private String peca;
	private String categoria;
	private String descricao;
	private String tamanho;
	private String cor;
	private String image_url;

	public Pecas() {}

	public Pecas(long id, double preco, String peca, String categoria, String descricao, String tamanho, String cor,
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pecas other = (Pecas) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
