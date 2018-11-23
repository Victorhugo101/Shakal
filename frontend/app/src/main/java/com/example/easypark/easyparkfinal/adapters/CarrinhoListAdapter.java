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
import com.example.easypark.easyparkfinal.beans.ProdutoPedido;

import java.util.List;

/**
 * Created by Renilson Albuquerque on 23/11/2018.
 */

public class CarrinhoListAdapter extends RecyclerView.Adapter<CarrinhoListAdapter.CarrinhoViewHolder> {

    private List<ProdutoPedido> produtosPedidos;
    private LayoutInflater mLayoutInflater;

    public CarrinhoListAdapter(Context c, List<ProdutoPedido> l){
        produtosPedidos = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public CarrinhoListAdapter.CarrinhoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = mLayoutInflater.inflate(R.layout.fragment_carrinho_row, viewGroup, false);
        return new  CarrinhoListAdapter.CarrinhoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CarrinhoViewHolder carrinhoViewHolder, int i) {

        carrinhoViewHolder.nomeProduto.setText(this.produtosPedidos.get(i).getNome());
        carrinhoViewHolder.valor.setText("R$ "+ Double.toString(this.produtosPedidos.get(i).getValor()));
        carrinhoViewHolder.quantidade.setText(Long.toString(this.produtosPedidos.get(i).getQuantidade()));
    }

    @Override
    public int getItemCount() {
        return this.produtosPedidos.size();
    }


    public class CarrinhoViewHolder extends RecyclerView.ViewHolder {

        public ImageView nomeImagem;
        public TextView nomeProduto;
        public TextView valor;
        public TextView quantidade;

        public CarrinhoViewHolder(View itemView) {
            super(itemView);

            nomeImagem = (ImageView) itemView.findViewById(R.id.imgProdutoCarrinho);
            nomeProduto = (TextView) itemView.findViewById(R.id.nomeProdutoCarrinho);
            valor = (TextView) itemView.findViewById(R.id.precoProdutoCarrinho);
            quantidade = (TextView) itemView.findViewById(R.id.quantidadeProdutoCarrinho);

        }
    }
}
