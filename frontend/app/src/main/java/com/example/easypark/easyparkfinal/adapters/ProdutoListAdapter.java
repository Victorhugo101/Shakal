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
import com.example.easypark.easyparkfinal.beans.Produto;

import java.util.List;

/**
 * Created by Renilson Albuquerque on 22/11/2018.
 */

public class ProdutoListAdapter extends RecyclerView.Adapter<ProdutoListAdapter.ProdutoViewHolder> {

        private List<Produto> produtos;
        private LayoutInflater mLayoutInflater;

        public ProdutoListAdapter(Context c, List<Produto> l){
            produtos = l;
            mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = mLayoutInflater.inflate(R.layout.fragment_truck_list_cell, viewGroup, false);
        return new ProdutoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder produtoViewHolder, int i) {
            produtoViewHolder.nomeProduto.setText(this.produtos.get(i).getNome());
    }

    @Override
    public int getItemCount() {
        return this.produtos.size();
    }

    public class ProdutoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView nomeImagem;
        public TextView nomeProduto;

        public ProdutoViewHolder(View itemView) {
            super(itemView);

            nomeImagem = (ImageView) itemView.findViewById(R.id.imgFoodTruck);
            nomeProduto = (TextView) itemView.findViewById(R.id.nomeFoodTruck);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

        }
    }
}
