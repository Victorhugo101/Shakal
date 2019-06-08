package br.com.easypark.backend.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import br.com.easypark.backend.model.enums.StatusPedidoEnum;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

	 @Id
	 @GeneratedValue
	 private Long id;
	

	 private StatusPedidoEnum status;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "id_cliente")
	 private Cliente cliente; 
	 
	 
	 @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	 @JoinTable(name = "mtm_pedido_produto", joinColumns = @JoinColumn(name = "id_pedido"), inverseJoinColumns = @JoinColumn(name = "id_produto"))
	 private List<Produto> produtos;
	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "id_mesa")
	 private Mesa mesa;

	 public Pedido() {
		
		}
	 

	public Pedido(StatusPedidoEnum status, Cliente cliente, List<Produto> produtos, Mesa mesa) {
		super();
		this.status = StatusPedidoEnum.PREPARANDO;
		this.cliente = cliente;
		this.produtos = produtos;
		this.mesa = mesa;
	}
	public Pedido(Cliente cliente, Mesa mesa) {
		super();
		this.status = status;
		this.cliente = cliente;
		this.produtos = new ArrayList<>();
		this.mesa = mesa;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	


	public StatusPedidoEnum getStatus() {
		return status;
	}


	public void setStatus(StatusPedidoEnum status) {
		this.status = status;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public Mesa getMesa() {
		return mesa;
	}


	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}


	
	 
	 
	 
	 
	 
}
