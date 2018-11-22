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
import com.example.easypark.easyparkfinal.adapters.CategoriaListAdapter;
import com.example.easypark.easyparkfinal.beans.Categoria;
import com.example.easypark.easyparkfinal.network.CategoriaService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategoriaListFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Categoria> categorias;
    private Call call;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_categoria_list, container, false);

        call = CategoriaService.listarCategorias();
        call.enqueue(new Callback<List<Categoria>>() {

                         @Override
                         public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                             Log.d("CallBack", " response is " + response.body());
                                categorias = CategoriaService.converterParaCategoria(response);
                         }

                         @Override
                         public void onFailure(Call<List<Categoria>> call, Throwable t) {
                             Log.d("Fudeu","Fudeu");
                             categorias=new ArrayList<>();
                             categorias.add(new Categoria(1L, "Raduken"));
                             categorias.add(new Categoria(1L, "Super Raduken, Ryu"));
                         }
        });

        categorias=new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_lista_categoria);

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        CategoriaListAdapter adapter = new CategoriaListAdapter(this.getContext(), categorias);
        recyclerView.setAdapter(adapter);
//        ft.commit();
        return view;
    }
}
