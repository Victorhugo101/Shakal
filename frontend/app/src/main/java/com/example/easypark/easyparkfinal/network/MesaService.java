package com.example.easypark.easyparkfinal.network;

import com.example.easypark.easyparkfinal.beans.QrCode;
import com.example.easypark.easyparkfinal.session.RetrofitBuilder;

import retrofit2.Call;

public class MesaService {

    public static Call<Long> autenticarMesa(QrCode qrCode){

        IBackendAPI service = RetrofitBuilder.getApiService();
        return service.auntenticarMesa(qrCode);
    }
}
