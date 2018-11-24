package br.com.easypark.backend.model.dto;

import java.io.Serializable;

public class PedidoSaidaDTO implements Serializable {

	private long id;
	private String nomeTruck;
	private String status;
	
	
	public PedidoSaidaDTO() {
		
	}
	
	
	public PedidoSaidaDTO(long id, String truck, String status) {
		super();
		this.id = id;
		this.nomeTruck = truck;
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	
	public String getNomeTruck() {
		return nomeTruck;
	}


	public void setNomeTruck(String nomeTruck) {
		this.nomeTruck = nomeTruck;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
