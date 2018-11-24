package br.com.easypark.backend.model.dto;

import java.io.Serializable;
import java.util.HashMap;

public class PedidoEntradaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long cliente;
	private HashMap<Long,Long> produtos;
	private Long mesa;
	
	public PedidoEntradaDTO() {
		
	}
	public PedidoEntradaDTO(Long cliente, HashMap<Long,Long> produtos, Long mesa) {
		super();
		this.cliente = cliente;
		this.produtos = produtos;
		this.mesa = mesa;
	}
	
	
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	
	public HashMap<Long, Long> getProdutos() {
		return produtos;
	}


	public void setProdutos(HashMap<Long, Long> produtos) {
		this.produtos = produtos;
	}


	public long getMesa() {
		return mesa;
	}
	public void setMesa(long mesa) {
		this.mesa = mesa;
	}
	
	
	

}
