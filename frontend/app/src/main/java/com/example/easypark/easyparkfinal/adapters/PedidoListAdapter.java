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
import com.example.easypark.easyparkfinal.beans.Pedido;


import java.util.List;

/**
 * Created by Renilson Albuquerque on 24/11/2018.
 */

public class PedidoListAdapter extends  RecyclerView.Adapter<PedidoListAdapter.PedidoViewHolder> {

    private List<Pedido> pedidos;
    private LayoutInflater mLayoutInflater;

    public PedidoListAdapter(Context c, List<Pedido> l){
        pedidos = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public PedidoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PedidoViewHolder pedidoViewHolder, int i) {
        pedidoViewHolder.nomeProduto.setText(this.pedidos.get(i).getNome());
        pedidoViewHolder.valor.setText(Double.toString(this.pedidos.get(i).getPreco()));
        pedidoViewHolder.quantidade.setText(this.pedidos.get(i).getQuantidade());
        pedidoViewHolder.status.setText(this.pedidos.get(i).getStatus());
    }

    @Override
    public int getItemCount() {
        return this.pedidos.size();
    }

    public class PedidoViewHolder extends RecyclerView.ViewHolder{

        public ImageView nomeImagem;
        public TextView nomeProduto;
        public TextView valor;
        public TextView quantidade;
        public TextView status;

        public PedidoViewHolder(View itemView) {
            super(itemView);

            nomeImagem = (ImageView) itemView.findViewById(R.id.imgProduto);
            nomeProduto = (TextView) itemView.findViewById(R.id.nomeProduto);
            valor = (TextView) itemView.findViewById(R.id.precoProduto);
            quantidade = (TextView) itemView.findViewById(R.id.quantidadeProdutoCarrinho);
            status = (TextView) itemView.findViewById(R.id.statusProdutoPedido);


        }


    }

}
