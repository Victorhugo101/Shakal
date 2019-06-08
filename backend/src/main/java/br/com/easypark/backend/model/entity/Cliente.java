package br.com.easypark.backend.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;

@Entity
@Table(name = "tb_cliente")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cliente extends User {
	
 
	 
	 @OneToMany(mappedBy = "cliente")
	 private List<Pedido> pedidos = new ArrayList<>();
	
	 public Cliente() {
		
	}
	

	public Cliente(String nomeCompleto, String email, String senha) {
		super.setUsername(nomeCompleto);
		super.setEmail(email);
		super.setPassword(senha);
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	 
	 
	 
}
