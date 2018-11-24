package com.example.easypark.easyparkfinal.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.beans.PedidoListView;


import java.util.List;

/**
 * Created by Renilson Albuquerque on 24/11/2018.
 */

public class PedidoListAdapter extends  RecyclerView.Adapter<PedidoListAdapter.PedidoViewHolder> {

    private List<PedidoListView> pedidos;
    private LayoutInflater mLayoutInflater;

    public PedidoListAdapter(Context c, List<PedidoListView> l){
        pedidos = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public PedidoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = mLayoutInflater.inflate(R.layout.fragment_pedido_list_row, viewGroup, false);
        return  new PedidoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidoViewHolder pedidoViewHolder, int i) {
        pedidoViewHolder.nomeTruck.setText(this.pedidos.get(i).getNomeTruck());
        //pedidoViewHolder.setText(Double.toString(this.pedidos.get(i).getPreco()));
        pedidoViewHolder.status.setText("Status: " + this.pedidos.get(i).getStatus());
    }

    @Override
    public int getItemCount() {
        return this.pedidos.size();
    }

    public class PedidoViewHolder extends RecyclerView.ViewHolder{

        public ImageView nomeImagem;
        public TextView nomeTruck;
        public TextView status;

        public PedidoViewHolder(View itemView) {
            super(itemView);

            nomeImagem = (ImageView) itemView.findViewById(R.id.imgProdutoPedido);
            nomeTruck = (TextView) itemView.findViewById(R.id.nomeFoodTruckPedido);
            status = (TextView) itemView.findViewById(R.id.statusProdutoPedido);


        }


    }

}
