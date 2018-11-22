package com.example.easypark.easyparkfinal.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.beans.Categoria;

import java.util.List;

/**
 * Created by Renilson Albuquerque on 21/11/2018.
 */

public class CategoriaListAdapter extends RecyclerView.Adapter
        <CategoriaListAdapter.CategoriaViewHolder> {

    private List<Categoria> categorias;
    private LayoutInflater mLayoutInflater;

    public CategoriaListAdapter (Context c, List<Categoria> l){
        categorias = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public CategoriaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.fragment_truck_list_cell, parent, false);
        return  new CategoriaViewHolder(v);

    }

    @Override
    public void onBindViewHolder(CategoriaListAdapter.CategoriaViewHolder holder, int position) {
        //   holder.nomeImagem.setText(foodTrucks.get(position).getNome());
        holder.nomeFoodTruck.setText(String.valueOf(categorias.get(position).getNome()));

    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public class CategoriaViewHolder extends RecyclerView.ViewHolder {

        public ImageView nomeImagem;
        public TextView nomeFoodTruck;

        public CategoriaViewHolder(View itemView) {
            super(itemView);

            nomeImagem = (ImageView) itemView.findViewById(R.id.imgFoodTruck);
            nomeFoodTruck = (TextView) itemView.findViewById(R.id.nomeFoodTruck);

        }
    }
}
