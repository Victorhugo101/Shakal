package br.com.easypark.backend.handler;

import java.io.IOException;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.easypark.backend.exception.ExceptionReponseDetail;

public class SecurityHandlerExceptionBuilder {
	
	public static ServletResponse handleError(HttpServletResponse response, int status, Exception exception) throws IOException {
        String json = new Gson().toJson( new ExceptionReponseDetail.Builder()
                .status(status)
                .title("Erro")
                .detail(exception.getMessage())
                .developerMessage(exception.getClass().toString())
                .build());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(json);
        response.setStatus(status);
        return response;
    }
	

}
