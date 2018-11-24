package br.com.easypark.backend.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	
	 @NotBlank
	 private String nomeCompleto;
	 
	 @NotBlank
	 private String email;
	
	 @NotBlank
	 private String senha;
	 
	 
	 @OneToMany(mappedBy = "cliente")
	 private List<Pedido> pedidos = new ArrayList<>();
	
	 public Cliente() {
		
		}
	

	public Cliente(String nomeCompleto, String email, String senha) {
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	 
	 
	 
}
