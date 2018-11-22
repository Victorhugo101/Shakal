package br.com.easypark.backend.model.dto;

import java.io.Serializable;

public class TruckDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	 private String nome;
	 private String img;
	 
	 
	 
	 
	public TruckDTO(Long id, String nome, String img) {
		super();
		this.id = id;
		this.nome = nome;
		this.img = img;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	 
	 
	 

}
