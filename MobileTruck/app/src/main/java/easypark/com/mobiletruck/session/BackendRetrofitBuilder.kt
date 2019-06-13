package easypark.com.mobiletruck.session

import easypark.com.mobiletruck.network.BackendAPI
import easypark.com.mobiletruck.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class BackendRetrofitBuilder {

    lateinit var backendAPI: BackendAPI

    init {
        backendAPI = provideRetrofit().create(BackendAPI::class.java)
    }


    fun provideRetrofit(): Retrofit{
        return  Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(provideOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun provideOkHttpClient(): OkHttpClient{
        val okhttpClientBuilder = OkHttpClient.Builder()
        okhttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS)
        okhttpClientBuilder.readTimeout(30, TimeUnit.SECONDS)
        okhttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS)

        //okhttpClientBuilder.addInterceptor(new TokenRenewInterceptor());
        okhttpClientBuilder.addInterceptor(AuthorizationInterceptor())
        return okhttpClientBuilder.build()
    }

    companion object {
        val instance = BackendRetrofitBuilder()

    }
}