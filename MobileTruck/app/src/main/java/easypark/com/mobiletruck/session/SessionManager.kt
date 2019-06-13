package easypark.com.mobiletruck.session

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences

class SessionManager {

    lateinit var session: Session
    lateinit var sharedPreferences: SharedPreferences



    fun createSession(sharedPreferences: SharedPreferences){
        this.sharedPreferences = sharedPreferences
        this.session = object : Session{
            override fun saveToken(token: String) {
                sharedPreferences.edit()
                        .putString("token",token).apply()
            }

            override fun getToken(): String? {
                return sharedPreferences.getString("token","DEFAULT")
            }

            override fun saveEmail(email: String) {
                sharedPreferences.edit()
                        .putString("email",email).apply()
            }

            override fun getEmail(): String? {
                return sharedPreferences.getString("email","DEFAULT")
            }

            override fun savePassword(password: String) {
                sharedPreferences.edit()
                        .putString("senha",password).apply()
            }

            override fun getPassword(): String? {
                return sharedPreferences.getString("senha","DEFAULT")
            }

            override fun invalidate() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun isLoggedIn(): Boolean {
                return sharedPreferences.contains("token")
            }
        }
    }
    companion object{
        val instance = SessionManager()
    }

}