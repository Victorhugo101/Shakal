package com.example.easypark.easyparkfinal.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Renilson Albuquerque on 22/11/2018.
 */

public class ProdutoListSerializable implements Serializable {

    private List<Produto> produtoList;

    public ProdutoListSerializable(List<Produto> produtos){
        this.produtoList = produtos;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }
}
