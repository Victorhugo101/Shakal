package br.com.easypark.backend.model.dto;

public class TokenDTO {
	
	public long id;
	public String email;
	public String token;
	
	public TokenDTO(long id, String email,String token) {
		this.id = id;
		this.email = email;
		this.token = token;
	}
	

}
