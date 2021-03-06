package br.com.easypark.backend.security;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import br.com.easypark.backend.exception.ExceptionReponseDetail;
import br.com.easypark.backend.handler.SecurityHandlerExceptionBuilder;
import br.com.easypark.backend.model.dto.LoginDTO;
import br.com.easypark.backend.model.dto.TokenDTO;
import br.com.easypark.backend.utils.Messages;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    protected JwtAuthenticationFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        LoginDTO loginDTO = null;
        try{
            loginDTO = new ObjectMapper().readValue(request.getInputStream(), LoginDTO.class);
            
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getEmail(),
                            loginDTO.getSenha()
                    )
            );
        }catch(JsonProcessingException e){
            throw new BadCredentialsException("Formato de JSON invalido");
        }
        catch(IOException e2){
            throw new BadCredentialsException("Erro no JSON");
        }
    }
    
    
    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {
    	AuthenticationContext customAuth = (AuthenticationContext) auth;
    	
    	String token = TokenAuthenticationService.addAuthentication(
    			customAuth.getId(),
    			customAuth.getName(),
    			customAuth.getAuthorities());
    	String json = new Gson().toJson( new TokenDTO(
    			customAuth.getId(),
    			customAuth.getEmail(),
    			token
    	));
    	res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().println(json);
        res.setStatus(HttpServletResponse.SC_OK);
    	
        
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        SecurityHandlerExceptionBuilder.handleError(response,HttpServletResponse.SC_UNAUTHORIZED,
                new BadCredentialsException(failed.getMessage()));


    }
}
