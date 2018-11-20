package br.com.easypark.backend.model.dto;

import java.io.Serializable;
import java.util.List;

public class PedidoEntradaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long cliente;
	private List<Long> produtos;
	private Long mesa;
	
	public PedidoEntradaDTO(Long cliente, List<Long> produtos, Long mesa) {
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
	public List<Long> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Long> produtos) {
		this.produtos = produtos;
	}
	public long getMesa() {
		return mesa;
	}
	public void setMesa(long mesa) {
		this.mesa = mesa;
	}
	
	
	

}
