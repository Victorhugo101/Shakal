package easypark.com.mobiletruck.activities


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import easypark.com.mobiletruck.R
import android.content.Context

import android.widget.EditText

import easypark.com.mobiletruck.network.UsuarioService


import easypark.com.mobiletruck.model.LoginDTO
import easypark.com.mobiletruck.model.Token

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast



class LoginActivity : AppCompatActivity() {

    private lateinit var txtLoginField: EditText
    private lateinit var txtPasswordField: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginButton = findViewById<Button>(R.id.btnEntrar)
        txtLoginField = findViewById<EditText>(R.id.txtLogin)
        txtPasswordField = findViewById<EditText>(R.id.txtPassword)

        // Set up the login form.
        loginButton.setOnClickListener { performLogin() }


    }

    fun performLogin(){
        val login = LoginDTO(txtLoginField.text.toString(), txtPasswordField.text.toString())
        val call = UsuarioService.newInstance().logarUsuario(login)
        call.enqueue(object : Callback<Token> {

            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                if (response.code() == 200) {

                    val sp = getSharedPreferences("usuario", Context.MODE_PRIVATE)
                    val ed = sp.edit()
                    ed.putString("token", response.body()!!.token)
                    ed.commit()
                    val intent = Intent(applicationContext, TruckMainApp::class.java)
                    startActivity(intent)
                } else
                    exibirMensagem("E-mail ou senha inválido!")

            }

            override fun onFailure(call: Call<Token>, t: Throwable) {
                exibirMensagem(t.message.toString())
            }

        })


    }

    fun exibirMensagem(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }





}
