package br.com.easypark.backend.model.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class PedidoEntradaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long cliente;
	private List<ProdutoQuantidadeDTO> produtos;
	private Long mesa;
	private Long truck;
	
	public PedidoEntradaDTO() {
		
	}
	public PedidoEntradaDTO(Long cliente, List<ProdutoQuantidadeDTO> produtos, Long mesa, Long truck) {
		super();
		this.cliente = cliente;
		this.produtos = produtos;
		this.mesa = mesa;
		this.truck = truck;
	}
	
	
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	
	


	public Long getTruck() {
		return truck;
	}
	public void setTruck(Long truck) {
		this.truck = truck;
	}
	public List<ProdutoQuantidadeDTO> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<ProdutoQuantidadeDTO> produtos) {
		this.produtos = produtos;
	}
	public long getMesa() {
		return mesa;
	}
	public void setMesa(long mesa) {
		this.mesa = mesa;
	}
	
	
	

}
