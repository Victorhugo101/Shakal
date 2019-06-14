package com.example.easypark.easyparkfinal.session;


import com.example.easypark.easyparkfinal.utils.Constants;

import java.io.IOException;


import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthorizationInterceptor implements Interceptor {

    private ISession session;


    public AuthorizationInterceptor() {
        this.session = SessionManager.getInstance().getSession();
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request mainRequest = chain.request();

        if (session.isLoggedIn()) {
            mainRequest = mainRequest.newBuilder().addHeader(Constants.AUTH_HEADER, session.getToken()).build();
        }
        return chain.proceed(mainRequest);

    }

}

 /*
            if (mainResponse.code() == 401 || mainResponse.code() == 403) {
                session.invalidate();
                LoginDTO loginDTO = new LoginDTO(session.getEmail(),session.getPassword());
                retrofit2.Response<TokenDTO> loginResponse = apiService.logarUsuario(loginDTO).execute();
                if(loginResponse.isSuccessful()){
                    session.saveToken(loginResponse.body().getToken());
                    Request.Builder builder = mainRequest.newBuilder().header("Authorization", session.getToken()).
                            method(mainRequest.method(), mainRequest.body());
                    mainResponse = chain.proceed(builder.build());
                }

            }
            */
