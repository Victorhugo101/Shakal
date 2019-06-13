package com.example.easypark.easyparkfinal.session;

import com.example.easypark.easyparkfinal.activity.SplashActivity;
import com.example.easypark.easyparkfinal.network.IBackendAPI;
import com.example.easypark.easyparkfinal.utils.Constants;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private static IBackendAPI backendAPI;

    public static IBackendAPI getApiService() {
        if (backendAPI == null) {
            backendAPI = RetrofitBuilder.provideRetrofit(Constants.BASE_URL).create(IBackendAPI.class);
        }
        return backendAPI;
    }

    public static Retrofit provideRetrofit(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(provideOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
    private static OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();
        okhttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okhttpClientBuilder.readTimeout(30, TimeUnit.SECONDS);
        okhttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS);

        //okhttpClientBuilder.addInterceptor(new TokenRenewInterceptor());
        okhttpClientBuilder.addInterceptor(new AuthorizationInterceptor());
        return okhttpClientBuilder.build();
    }
}
