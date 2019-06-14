package easypark.com.mobiletruck.network


import easypark.com.mobiletruck.model.LoginDTO
import easypark.com.mobiletruck.model.Token
import easypark.com.mobiletruck.session.BackendRetrofitBuilder


import retrofit2.Call



class UsuarioService {

    fun logarUsuario(login: LoginDTO): Call<Token> {
        var instance = BackendRetrofitBuilder.instance.backendAPI
        return instance.logarUsuario(login)
        /*
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(BackendAPI::class.java)
        return service.logarUsuario(login)
        */
    }

    companion object {
        fun newInstance() = UsuarioService()
    }
}