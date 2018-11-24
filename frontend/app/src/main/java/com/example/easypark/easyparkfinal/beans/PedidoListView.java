package com.example.easypark.easyparkfinal.beans;

/**
 * Created by Renilson Albuquerque on 24/11/2018.
 */

public class PedidoListView {


    private long id;
    private String nomeTruck;
    private String status;


    public PedidoListView(long id, String nomeTruck, String status) {
        this.id = id;
        this.nomeTruck = nomeTruck;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeTruck() {
        return nomeTruck;
    }

    public void setNomeTruck(String nomeTruck) {
        this.nomeTruck = nomeTruck;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
