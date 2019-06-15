package easypark.com.mobiletruck.session


import android.content.SharedPreferences

class SessionManager {

    lateinit var session: Session
    lateinit var sharedPreferences: SharedPreferences



    fun createSession(sharedPreferences: SharedPreferences){
        this.sharedPreferences = sharedPreferences
        this.session = object : Session{
            override fun getId(): Long {
                return sharedPreferences.getLong("id",0)

            }

            override fun saveId(id: Long) {
                sharedPreferences.edit()
                        .putLong("id",id).apply()
            }

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
                sharedPreferences.edit().remove("email")
                        .remove("senha")
                        .remove("token").apply()
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