package com.example.easypark.easyparkfinal.session;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;


public class TokenRenewInterceptor implements Interceptor{

    private Session session;

    public TokenRenewInterceptor(Session session) {
        this.session = session;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {

        Response response = chain.proceed(chain.request());
        String newToken = response.header("Authorization");
        if (newToken != null) {
            session.saveToken(newToken);
        }

        return response;
    }
}
