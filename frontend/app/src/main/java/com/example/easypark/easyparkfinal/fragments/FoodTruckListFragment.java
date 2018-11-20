package com.example.easypark.easyparkfinal.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.adapters.TruckListAdapter;
import com.example.easypark.easyparkfinal.beans.FoodTruck;

import java.util.ArrayList;


public class FoodTruckListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<FoodTruck> foodTrucks;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_truck_list, container, false);


        foodTrucks=new ArrayList<>();
        foodTrucks.add(new FoodTruck(1L, "barraca do veio", " "));
        foodTrucks.add(new FoodTruck(1L, "barraca do outro veio", " "));

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_lista_truck);

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        TruckListAdapter adapter = new TruckListAdapter(this.getContext(), foodTrucks);
        recyclerView.setAdapter(adapter);
//        ft.commit();
        return view;
    }


}
