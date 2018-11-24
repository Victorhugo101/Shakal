package com.example.easypark.easyparkfinal.beans;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Renilson Albuquerque on 24/11/2018.
 */

public class PedidoDTO implements Serializable {


    private long cliente;
    private long mesa;
    private HashMap<Long,Long> produtos;

    public PedidoDTO( long cliente, long mesa, HashMap<Long, Long> produtos) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.produtos = produtos;
    }

    public long getCliente() {
        return cliente;
    }

    public void setCliente(long cliente) {
        this.cliente = cliente;
    }

    public long getMesa() {
        return mesa;
    }

    public void setMesa(long mesa) {
        this.mesa = mesa;
    }

    public HashMap<Long, Long> getProdutos() {
        return produtos;
    }

    public void setProdutos(HashMap<Long, Long> produtos) {
        this.produtos = produtos;
    }
}
