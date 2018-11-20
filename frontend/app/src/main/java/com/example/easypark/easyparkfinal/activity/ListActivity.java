package com.example.easypark.easyparkfinal.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.easypark.easyparkfinal.R;

import com.example.easypark.easyparkfinal.fragments.FoodTruckListFragment;


public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,
                new FoodTruckListFragment()).commit();

    }

}
