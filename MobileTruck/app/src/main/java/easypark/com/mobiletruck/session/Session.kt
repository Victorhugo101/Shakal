package easypark.com.mobiletruck.session

interface Session {

    fun isLoggedIn(): Boolean

    fun saveToken(token: String)

    fun getToken(): String?

    fun saveEmail(email: String)

    fun getEmail(): String?

    fun savePassword(password: String)

    fun getPassword(): String?

    fun invalidate()
}