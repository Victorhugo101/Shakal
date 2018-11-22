package com.example.easypark.easyparkfinal.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.adapters.ProdutoListAdapter;
import com.example.easypark.easyparkfinal.beans.Produto;
import com.example.easypark.easyparkfinal.beans.ProdutoListSerializable;
import com.example.easypark.easyparkfinal.beans.Truck;

import java.util.List;

import retrofit2.Call;


public class ProdutoListFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Produto> foodTrucks;
    private Call call;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_produto_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_lista_produto);

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        Bundle bundle = getArguments();
        List<Produto> tls =((ProdutoListSerializable) bundle.getSerializable("produtos")).getProdutoList();
        ProdutoListAdapter adapter = new ProdutoListAdapter(this.getContext(),tls );
        recyclerView.setAdapter(adapter);
        return view;
    }


}
