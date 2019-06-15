package br.com.easypark.backend.model.dto;

import java.io.Serializable;


public class ProdutoDTO implements Serializable{

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -1305963418635418690L;
	private Long id;
	private String nome;
	private String valor;
	 
	 
	 
	public ProdutoDTO(Long id, String nome, String valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	 
	 
}
