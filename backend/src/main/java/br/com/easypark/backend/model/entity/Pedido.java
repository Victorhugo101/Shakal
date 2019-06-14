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
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "id_truck")
	 private Truck truck;
	 
	 
	 @ManyToMany(cascade =  CascadeType.MERGE)
	 @JoinTable(name = "mtm_pedido_produto", joinColumns = 
	 @JoinColumn(name = "id_pedido",referencedColumnName = "id"), 
	 		inverseJoinColumns = @JoinColumn(name = "id_produto",referencedColumnName = "id"))
	 private List<Produto> produtos;
	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "id_mesa")
	 private Mesa mesa;

	 public Pedido() {}
	 

	public Pedido( Cliente cliente, List<Produto> produtos, Mesa mesa, Truck truck) {
		super();
		this.status = StatusPedidoEnum.PREPARANDO;
		this.cliente = cliente;
		this.produtos = produtos;
		this.mesa = mesa;
		this.truck = truck;
	}
	public Pedido(Cliente cliente, Mesa mesa, Truck truck) {
		super();
		this.status = StatusPedidoEnum.PREPARANDO;
		this.cliente = cliente;
		this.produtos = new ArrayList<>();
		this.mesa = mesa;
		this.truck = truck;
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


	public Truck getTruck() {
		return truck;
	}


	public void setTruck(Truck truck) {
		this.truck = truck;
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
