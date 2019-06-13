package easypark.com.mobiletruck.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import easypark.com.mobiletruck.R
import easypark.com.mobiletruck.session.SessionManager
import easypark.com.mobiletruck.utils.Constants

class ActivitySplash : AppCompatActivity() {

    var handler: Handler

    init{
        handler = Handler()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        ititializeSession()
        handler.postDelayed( {
            if (!SessionManager.instance.session.isLoggedIn()) {
                goToLoginScreen()
            } else {
                goToMainScreen()
            }
        }, Constants.SPLASH_TIME)
    }

    fun ititializeSession(){
        SessionManager.instance.createSession(getSharedPreferences("usuario", Context.MODE_PRIVATE))
    }

    fun goToLoginScreen(){
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
    }
    fun goToMainScreen(){
        val intent = Intent(applicationContext, TruckMainApp::class.java)
        startActivity(intent)
    }
}
