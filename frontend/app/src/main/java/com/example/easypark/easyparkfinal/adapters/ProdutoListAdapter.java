package com.example.easypark.easyparkfinal.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.beans.Produto;
import com.example.easypark.easyparkfinal.fragments.ComprarProdutoFragment;

import java.util.List;

/**
 * Created by Renilson Albuquerque on 22/11/2018.
 */

public class ProdutoListAdapter extends RecyclerView.Adapter<ProdutoListAdapter.ProdutoViewHolder> {

        private List<Produto> produtos;
        private LayoutInflater mLayoutInflater;
        private RecycleViewClickListener recycleViewClickListener;

        public ProdutoListAdapter(Context c, List<Produto> l){
            produtos = l;
            mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = mLayoutInflater.inflate(R.layout.fragment_produto_list_row, viewGroup, false);
        return new ProdutoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder produtoViewHolder, int i) {
            produtoViewHolder.nomeProduto.setText(this.produtos.get(i).getNome());
            produtoViewHolder.valor.setText("R$ "+ Double.toString(this.produtos.get(i).getValor()));
    }

    @Override
    public int getItemCount() {
        return this.produtos.size();
    }

    public void chamaProximoFragmento(int position, final Fragment fragmento){
        Bundle bundle = new Bundle();
        bundle.putSerializable("produto", this.produtos.get(position));
        ComprarProdutoFragment fragment = new ComprarProdutoFragment();
        /*
        fragment.setArguments(bundle);
        fragmento.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,
                fragment).commit();
    */
        fragment.setArguments(bundle);
        FragmentTransaction ft = fragmento.getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_container, fragment);
        ft.addToBackStack("ListComprarProduto");
        ft.commit();
    }

    public class ProdutoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView nomeImagem;
        public TextView nomeProduto;
        public TextView valor;

        public ProdutoViewHolder(View itemView) {
            super(itemView);

            nomeImagem = (ImageView) itemView.findViewById(R.id.imgProduto);
            nomeProduto = (TextView) itemView.findViewById(R.id.nomeProduto);
            valor = (TextView) itemView.findViewById(R.id.precoProduto);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (recycleViewClickListener != null){
                recycleViewClickListener.onClickListener(view, getAdapterPosition());
            }
        }
    }
    public void setContatoRecycleViewOnClick(RecycleViewClickListener r){
        this.recycleViewClickListener = r;
    }
}
