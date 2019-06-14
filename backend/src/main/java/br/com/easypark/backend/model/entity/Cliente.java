package br.com.easypark.backend.model.entity;


import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "tb_cliente")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cliente extends User {
	
 
	 
	 @OneToMany(mappedBy = "cliente")
	 private List<Pedido> pedidos;
	
	 public Cliente() {
		
	}
	

	public Cliente(String email,String nomeCompleto, String senha) {
		super.setUsername(nomeCompleto);
		super.setEmail(email);
		super.setPassword(senha);
		super.setEnabled(true);
	
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	 
	 
	 
}
