package br.com.easypark.backend.model.dto;

import java.util.List;

public class PedidoDetalheDTO {
	
	private long id;
	private String nomeCliente;
	private int mesa;
	private String status;
	private List<PedidoProdutoDTO> produtos;
	
	
	
	
	public PedidoDetalheDTO() {
		super();
	}
	public PedidoDetalheDTO(long id, String nomeCliente, int mesa, String status, List<PedidoProdutoDTO> produtos) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.mesa = mesa;
		this.status = status;
		this.produtos = produtos;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public int getMesa() {
		return mesa;
	}
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<PedidoProdutoDTO> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<PedidoProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	
	

}
