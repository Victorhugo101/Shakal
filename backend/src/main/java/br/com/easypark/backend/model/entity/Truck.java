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
@Table(name = "tb_truck")
public class Truck {

	 @Id
	 @GeneratedValue
	 private Long id;
	
	 @NotBlank
	 private String cnpj;
	 
	 @NotBlank
	 private String nomeFantasia;
	 
	 @NotBlank
	 private String email;
	 
	 @NotBlank
	 private String senha;
	 
	 private double latitude;
	 
	 private double longitude;
	 
	 @OneToMany(mappedBy = "truck", cascade = CascadeType.ALL)
	 private List<Produto> produtos = new ArrayList<>();
	 public Truck( ) {
			
		}
	public Truck( String cnpj,String nomeFantasia, String email,  String senha) {
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
