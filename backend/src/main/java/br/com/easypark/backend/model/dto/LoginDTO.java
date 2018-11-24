package br.com.easypark.backend.model.dto;

import java.io.Serializable;

public class LoginDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5916346435299796999L;
	private String email;
	private String senha;
	
	public LoginDTO() {
		
	}
	
	public LoginDTO(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	

}
