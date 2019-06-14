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
	 private String qrcode;
	 
	 private int capacidade;
	 
	 private double latitude;
	 private double longitude;
	 
	 
	 @OneToMany(mappedBy = "mesa", cascade = CascadeType.ALL)
	 private List<Pedido> pedidos = new ArrayList<>();
	 
	 public Mesa() {
			
	 }
	 
	 public Mesa(String qrCode, int capacidade) {
		this.qrcode = qrCode;
		this.capacidade = capacidade;
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQrCode() {
		return qrcode;
	}

	public void setQrCode(String qrCode) {
		this.qrcode = qrCode;
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
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	 
	 
	 
}
