package com.example.easypark.easyparkfinal.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.easypark.easyparkfinal.R;
import com.example.easypark.easyparkfinal.adapters.PedidoListAdapter;
import com.example.easypark.easyparkfinal.beans.PedidoListSerializable;
import com.example.easypark.easyparkfinal.beans.PedidoListView;

import java.util.List;


public class ListaPedidosFragments extends Fragment {


    private RecyclerView recyclerView;
    private List<PedidoListView> pedidos;
    private CountDownTimer mCountDownTimer;
    private ProgressBar mTimerBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_pedidos, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_lista_pedidos);
        mTimerBar = (ProgressBar) view.findViewById(R.id.timer_progress);

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        Bundle bundle = getArguments();
        List<PedidoListView> tls =((PedidoListSerializable) bundle.getSerializable("pedidos")).getPedidoListViewList();
        PedidoListAdapter adapter = new PedidoListAdapter(this.getContext(),tls );
        recyclerView.setAdapter(adapter);

        this.regressiveCounter();
        return view;
    }

    private void regressiveCounter(){
        mCountDownTimer = new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int progress = (int) (millisUntilFinished/1200);
                mTimerBar.setProgress(progress);
            }
            @Override
            public void onFinish() {
                //Do what you want
                mTimerBar.setProgress(0);
                onCreate(getArguments());
                //loadLista();
            }
        };
        mCountDownTimer.start();
    }


}
