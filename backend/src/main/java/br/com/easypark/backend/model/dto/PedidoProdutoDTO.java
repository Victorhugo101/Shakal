package br.com.easypark.backend.model.dto;

public class PedidoProdutoDTO {
	
	private long id;
	private String nome;
	private double valor;
	private int quantidade;
	
	
	
	
	public PedidoProdutoDTO() {
		super();
	}
	public PedidoProdutoDTO(long id, String nome, double valor, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
