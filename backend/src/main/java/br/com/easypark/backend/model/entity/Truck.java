package br.com.easypark.backend.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_truck")
public class Truck extends User{


	 @NotBlank
	 private String cnpj;
	 
	 @NotBlank
	 private String nomeFantasia;
	 
	 private double latitude;
	 
	 private double longitude;
	 
	 @OneToMany(mappedBy = "truck")
	 private List<Produto> produtos = new ArrayList<>();
	 
	 
	 public Truck( ) {
			
		}
	public Truck( String cnpj,String nomeFantasia, String email,  String senha) {
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		this.setEmail(email);
		this.setPassword(senha);
	}
	public Truck(String cnpj,String nomeFantasia, String email,  String senha,
			double latitude, double longitude) {
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		this.setEmail(email);
		this.setPassword(senha);
		this.latitude = latitude;
		this.longitude = longitude;
	}

	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
	 
	
	
	 
	 
}
