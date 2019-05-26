package easypark.com.mobiletruck.activities


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import easypark.com.mobiletruck.R


class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginButton = findViewById<Button>(R.id.btnEntrar)

        // Set up the login form.
        loginButton.setOnClickListener { performLogin() }


    }

    fun performLogin(){
        //Do Login
        val intent = Intent(applicationContext, TruckMainApp::class.java)
        startActivity(intent)
    }





}
