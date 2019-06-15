package br.com.easypark.backend.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 @Column(name ="Id")
	 private Long id;
	
	 @NotBlank
	 private String nome;
	 
	 
	 private double valor;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "id_categoria")
	 private Categoria categoira; 

	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "id_truck")
	 private Truck truck;
	 
	 
	 @ManyToMany(fetch = FetchType.LAZY, mappedBy = "produtos")
	 private List<Pedido> pedidos;
	 
	 
	 
	 
	 public Produto() {
			
	}
	 public Produto( String nome,double valor) {
			this.nome = nome;
			this.valor = valor;
		}
	 
	public Produto( String nome,double valor, Categoria categoria) {
		this.nome = nome;
		this.valor = valor;
		this.categoira = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Categoria getCategoira() {
		return categoira;
	}

	public void setCategoira(Categoria categoira) {
		this.categoira = categoira;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}
	 
	 /*
	 @ManyToMany(mappedBy = "serieDisciplinas")
	    private List<Aluno> alunos = new ArrayList<>();
	    */
	 
	 

	 
	 

}