package easypark.com.mobiletruck.network

import android.provider.SyncStateContract
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import easypark.com.mobiletruck.model.LoginDTO
import easypark.com.mobiletruck.model.Token
import easypark.com.mobiletruck.utils.Constants
import retrofit2.Call


class UsuarioService {

    fun logarUsuario(login: LoginDTO): Call<Token> {
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(BackendAPI::class.java)
        return service.logarUsuario(login)
    }

    companion object {
        fun newInstance() = UsuarioService()
    }
}