package com.example.easypark.easyparkfinal.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Renilson Albuquerque on 24/11/2018.
 */

public class PedidoListSerializable implements Serializable {

    private List<PedidoListView> pedidoListViewList;

    public PedidoListSerializable(List<PedidoListView> pedidoListViewList) {
        this.pedidoListViewList = pedidoListViewList;
    }

    public List<PedidoListView> getPedidoListViewList() {
        return pedidoListViewList;
    }

    public void setPedidoListViewList(List<PedidoListView> pedidoListViewList) {
        this.pedidoListViewList = pedidoListViewList;
    }
}
