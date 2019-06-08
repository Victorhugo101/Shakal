package br.com.easypark.backend.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "tb_role")
public class Role implements GrantedAuthority {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;

	@ManyToMany(mappedBy = "roles")
	private List<User> usuarios;
	
	
	@Override
	public String getAuthority() {
	
		return nome;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public List<User> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}
