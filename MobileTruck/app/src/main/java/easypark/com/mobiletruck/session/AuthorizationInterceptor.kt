package easypark.com.mobiletruck.session

import easypark.com.mobiletruck.utils.Constants
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor: Interceptor {

    var session: Session

    init {
        this.session = SessionManager.instance.session
    }

    override fun intercept(chain: Interceptor.Chain): Response {

        var mainRequest = chain.request()

        if (session.isLoggedIn()) {
            val token = session.getToken()
            mainRequest = mainRequest.newBuilder().addHeader(Constants.AUTH_HEADER, session.getToken().orEmpty()).build()
        }

        return chain.proceed(mainRequest)
    }
}