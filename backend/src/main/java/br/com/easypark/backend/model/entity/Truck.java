package br.com.easypark.backend.model.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_truck")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Truck {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    private String email;

    @NotEmpty
    @Column(nullable = false)
    private String username;

    @NotEmpty
    @Column(nullable = false)
    private String password;


	 @NotBlank
	 private String cnpj;
	 
	 @NotBlank
	 private String nomeFantasia;
	 
	 private double latitude;
	 
	 private double longitude;
	 

	 
	 @Column( nullable = false)
	    private Boolean activated;
	 
	 public Truck( ) {
			
		}
	public Truck( String cnpj,String nomeFantasia, String uername,String email,  String senha) {
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		this.setEmail(email);
		this.setPassword(senha);
	}
	public Truck(String cnpj,String nomeFantasia,String username, String email,  String senha,
			double latitude, double longitude) {
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		
		this.setUsername(username);
		this.setEmail(email);
		this.setPassword(senha);
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	
	
	
	
	
	public Boolean getActivated() {
		return activated;
	}
	public void setActivated(Boolean activated) {
		this.activated = activated;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
