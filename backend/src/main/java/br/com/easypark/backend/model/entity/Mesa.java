package br.com.easypark.backend.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_mesa")
public class Mesa {
	
	 @Id
	 @GeneratedValue
	 private Long id;
	
	 @NotBlank
	 private String qrCode;
	 
	 private int capacidade;
	 
	 @OneToMany(mappedBy = "mesa", cascade = CascadeType.ALL)
	 private List<Pedido> pedidos = new ArrayList<>();
	 
	 
	public Mesa(String qrCode, int capacidade, List<Pedido> pedidos) {
		this.qrCode = qrCode;
		this.capacidade = capacidade;
		this.pedidos = pedidos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	 
	 
	 
}
