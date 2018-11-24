package com.example.easypark.easyparkfinal.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.adapters.CarrinhoListAdapter;
import com.example.easypark.easyparkfinal.beans.Produto;
import com.example.easypark.easyparkfinal.beans.ProdutoPedido;
import com.example.easypark.easyparkfinal.beans.Truck;
import com.example.easypark.easyparkfinal.beans.TruckListSerializable;

import java.util.ArrayList;
import java.util.List;


public class CarrinhoFragment extends Fragment {

    private List<ProdutoPedido> produtosPedidos;
    private RecyclerView recyclerView;
    private Button btnConfirmarCompra;
    private static CarrinhoFragment instance;


    public CarrinhoFragment() {
        produtosPedidos = new ArrayList<>();
    }

    /*
    public static CarrinhoFragment newInstance() {
        CarrinhoFragment fragment = new CarrinhoFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    */
    public static CarrinhoFragment getInstance(){
        return (instance == null)? new CarrinhoFragment(): instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_carrinho, container, false);
       btnConfirmarCompra = (Button) view.findViewById(R.id.btnConfirmarCompra);
       recyclerView = (RecyclerView) view.findViewById(R.id.rv_lista_carrinho);



       Bundle bundle = getArguments();
       Produto produto = ((Produto) bundle.getSerializable("produto"));
       int quantidade = (int) bundle.getSerializable("quantidade");
       this.produtosPedidos.add(new ProdutoPedido(produto.getId(),produto.getNome(),produto.getValor(),quantidade));

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        CarrinhoListAdapter adapter = new CarrinhoListAdapter(this.getContext(),produtosPedidos);
        recyclerView.setAdapter(adapter);

        btnConfirmarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                confirmarCompra();

            }
        });
        return view;
    }

    private boolean confirmarCompra(){
        Toast.makeText(this.getContext(),"Compra confirmada",Toast.LENGTH_SHORT).show();
        return true;
    }

}
