package com.example.easypark.easyparkfinal.beans;

public class Truck {
    private Long id;
    private String nome;
    private String img;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;

    }

    public Truck(Long id, String nome, String img) {
        this.id = id;
        this.nome = nome;
        this.img = img;
    }
}
