package com.example.easypark.easyparkfinal.beans;

import java.io.Serializable;

/**
 * Created by Renilson Albuquerque on 23/11/2018.
 */

public class ProdutoPedido implements Serializable {

    private Long id;
    private String nome;
    private double valor;
    private int quantidade;

    public ProdutoPedido(Long id, String nome, double valor, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
