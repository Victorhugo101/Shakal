package com.example.easypark.easyparkfinal.beans;

import java.io.Serializable;

public class Cliente implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private String senha;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cliente(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;

        this.email = email;
        this.senha = senha;
    }
}