package com.example.easypark.easyparkfinal.beans;

/**
 * Created by Renilson Albuquerque on 21/11/2018.
 */

public class Categoria {

    private long id;
    private String nome;

    public Categoria(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
