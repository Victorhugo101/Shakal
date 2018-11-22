package com.example.easypark.easyparkfinal.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.beans.Produto;
import com.example.easypark.easyparkfinal.beans.ProdutoListSerializable;
import com.example.easypark.easyparkfinal.beans.Truck;
import com.example.easypark.easyparkfinal.beans.TruckListSerializable;
import com.example.easypark.easyparkfinal.fragments.FoodTruckListFragment;
import com.example.easypark.easyparkfinal.fragments.ProdutoListFragment;
import com.example.easypark.easyparkfinal.network.ProdutoService;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TruckListAdapter extends RecyclerView.Adapter
             <TruckListAdapter.FoodTruckViewHolder>{

        private List<Truck> foodTrucks;
        private LayoutInflater mLayoutInflater;
        private RecycleViewClickListener recycleViewClickListener;

        public TruckListAdapter (Context c, List<Truck> l){
           foodTrucks = l;
           mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
    public void chamaProximoFragmento(int position, final Fragment fragmento, View view){



        //View view =  inflater.inflate(R.layout.fragment_truck_list, container, false);
        /*
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_lista_produto);
        LinearLayoutManager llm = new LinearLayoutManager(fragmento.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
*/
        Call call = ProdutoService.listarProdutosPorTruck(foodTrucks.get(position).getId());
        call.enqueue(new Callback<List<Produto>>() {

                         @Override
                         public void onResponse(Call<List<Produto>> call, Response<List<Produto>> response) {
                             Bundle bundle = new Bundle();
                             bundle.putSerializable("produtos", new ProdutoListSerializable(
                                     ProdutoService.converterParaProduto(response)));
                             ProdutoListFragment fragment = new ProdutoListFragment();
                             fragment.setArguments(bundle);
                             fragmento.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,
                                     fragment).commit();
                         }

                         @Override
                         public void onFailure(Call<List<Produto>> call, Throwable t) {

                         }
                     });
        /*
            ProdutoListAdapter adapter = new ProdutoListAdapter(fragmento.getContext(),tls );
        recyclerView.setAdapter(adapter);
        */
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

    public class FoodTruckViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView nomeImagem;
        public TextView nomeFoodTruck;

        public FoodTruckViewHolder(View itemView) {
            super(itemView);

            nomeImagem = (ImageView) itemView.findViewById(R.id.imgFoodTruck);
            nomeFoodTruck = (TextView) itemView.findViewById(R.id.nomeFoodTruck);
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
