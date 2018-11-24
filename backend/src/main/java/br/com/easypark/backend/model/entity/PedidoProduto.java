package br.com.easypark.backend.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "mtm_pedido_produto")
public class PedidoProduto implements Serializable{

	@Id
	@GeneratedValue
	private long id;
	

    @ManyToOne(targetEntity = Produto.class)
    @JoinColumn(name = "id_produto" , referencedColumnName = "id")
    private Produto produto;


    @ManyToOne(targetEntity = Pedido.class)
    @JoinColumn(name = "id_pedido" , referencedColumnName = "id")
    private Pedido pedido;
    
   
    private int quantidade;
    
    

	public PedidoProduto(Produto produto,Pedido pedido, int quantidade) {
		this.produto = produto;
		this.pedido = pedido;
		this.quantidade = quantidade;
	}

	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
    
    
    
}
