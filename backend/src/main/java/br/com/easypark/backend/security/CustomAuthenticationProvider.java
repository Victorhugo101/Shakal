package br.com.easypark.backend.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.easypark.backend.service.UsuarioService;
import br.com.easypark.backend.utils.Messages;
import br.com.easypark.backend.utils.PasswordEncoder;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    private UsuarioService userService;
    
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        try {
            UserDetails user = this.userService.loadUserByEmail(email);
            if (encoder.bCryptPasswordEncoder().matches(password, user.getPassword())) {
                return new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        password,
                        user.getAuthorities()
                );
            }else{
                throw new BadCredentialsException(Messages.INVALID_PASSWORD);
            }

        }catch(UsernameNotFoundException e){
            throw new BadCredentialsException(Messages.USER_NOT_FOUND);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
