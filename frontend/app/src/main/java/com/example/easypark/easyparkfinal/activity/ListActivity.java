package com.example.easypark.easyparkfinal.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.easypark.easyparkfinal.R;

import com.example.easypark.easyparkfinal.beans.Truck;
import com.example.easypark.easyparkfinal.beans.TruckListSerializable;
import com.example.easypark.easyparkfinal.fragments.FoodTruckListFragment;
import com.example.easypark.easyparkfinal.network.TruckService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        Call call = TruckService.listarTrcksPerto();
        call.enqueue(new Callback<List<Truck>>() {

            @Override
            public void onResponse(Call<List<Truck>> call, Response<List<Truck>> response) {
                List<Truck> foodTrucks = TruckService.converterParaTruck(response);
                Bundle bundle = new Bundle();
                bundle.putSerializable("trucks",new TruckListSerializable(foodTrucks));

                FoodTruckListFragment fragment = new FoodTruckListFragment();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container,
                        fragment).commit();
            }

            @Override
            public void onFailure(Call<List<Truck>> call, Throwable t) {

            }
        });

    }

}
