package br.com.easypark.backend.model.dto;

/**
 * Created by Renilson Albuquerque on 24/11/2018.
 */

public class ProdutoQuantidadeDTO {


    private Long produto;
    private Long quantidade;

    public ProdutoQuantidadeDTO() {
    	
    }
    public ProdutoQuantidadeDTO(Long produto, Long quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
