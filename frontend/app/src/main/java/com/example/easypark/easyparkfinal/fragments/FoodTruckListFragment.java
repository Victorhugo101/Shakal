package com.example.easypark.easyparkfinal.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.adapters.RecycleViewClickListener;
import com.example.easypark.easyparkfinal.adapters.TruckListAdapter;
import com.example.easypark.easyparkfinal.beans.Categoria;
import com.example.easypark.easyparkfinal.beans.Truck;
import com.example.easypark.easyparkfinal.network.CategoriaService;
import com.example.easypark.easyparkfinal.network.TruckService;
import com.example.easypark.easyparkfinal.beans.TruckListSerializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FoodTruckListFragment extends Fragment implements RecycleViewClickListener {

    private RecyclerView recyclerView;
    private List<Truck> foodTrucks;
    private Call call;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_truck_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_lista_truck);

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        Bundle bundle = getArguments();
        List<Truck> tls =((TruckListSerializable) bundle.getSerializable("trucks")).truckList;
        TruckListAdapter adapter = new TruckListAdapter(this.getContext(),tls );
        adapter.setContatoRecycleViewOnClick(this);
        recyclerView.setAdapter(adapter);
//        ft.commit();
        return view;
    }


    @Override
    public void onClickListener(View view, int position) {
        TruckListAdapter adapter = (TruckListAdapter) recyclerView.getAdapter();
        adapter.chamaProximoFragmento(position,this, view);
    }
}
