package com.example.easypark.easyparkfinal.beans;

/**
 * Created by Renilson Albuquerque on 21/11/2018.
 */

public class Produto {

    private Long id;
    private String nome;
    private String valor;

    public Produto(Long id, String nome, String valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
