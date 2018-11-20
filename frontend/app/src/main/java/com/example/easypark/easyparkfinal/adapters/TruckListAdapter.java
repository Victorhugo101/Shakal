package com.example.easypark.easyparkfinal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.beans.FoodTruck;

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class TruckListAdapter extends RecyclerView.Adapter
             <TruckListAdapter.FoodTruckViewHolder>{

        private List<FoodTruck> foodTrucks;
        private LayoutInflater mLayoutInflater;

        public TruckListAdapter (Context c, ArrayList<FoodTruck> l){
           foodTrucks = l;
           mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

    @Override
    public FoodTruckViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.fragment_truck_list_cell, parent, false);
        return  new FoodTruckViewHolder(v);

    }

    @Override
    public void onBindViewHolder(FoodTruckViewHolder holder, int position) {
     //   holder.nomeImagem.setText(foodTrucks.get(position).getNome());
        holder.nomeFoodTruck.setText(String.valueOf(foodTrucks.get(position).getNome()));

    }

    @Override
    public int getItemCount() {
        return foodTrucks.size();
    }

    public class FoodTruckViewHolder extends RecyclerView.ViewHolder {

        public ImageView nomeImagem;
        public TextView nomeFoodTruck;

        public FoodTruckViewHolder(View itemView) {
            super(itemView);

            nomeImagem = (ImageView) itemView.findViewById(R.id.imgFoodTruck);
            nomeFoodTruck = (TextView) itemView.findViewById(R.id.nomeFoodTruck);

        }
    }
}
