package br.com.easypark.backend.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.easypark.backend.model.enums.StatusPedidoEnum;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private StatusPedidoEnum status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_truck")
	private Truck truck;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pedido")
	private List<PedidoProduto> produtos;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_mesa")
	private Mesa mesa;

	public Pedido() {
	}

	public Pedido(Cliente cliente, List<PedidoProduto> produtos, Mesa mesa, Truck truck) {
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

	

	public List<PedidoProduto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<PedidoProduto> produtos) {
		this.produtos = produtos;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

}
