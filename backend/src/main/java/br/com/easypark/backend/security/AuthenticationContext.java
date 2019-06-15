package br.com.easypark.backend.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import br.com.easypark.backend.model.entity.Role;

public class AuthenticationContext implements Authentication {
	
	private Boolean authenticated;
    private Long id;
    private String email;
    private String password;
    private Collection<Role> authorities;
    
    
    
    
	public AuthenticationContext(Boolean authenticated, Long id, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.authenticated = authenticated;
		this.id = id;
		this.email = email;
		this.password = password;
		this.authorities = (Collection<Role>) authorities;
	}
	public Boolean getAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Collection<Role> authorities) {
		this.authorities = authorities;
	}
	@Override
	public String getName() {
		return this.getEmail();
	}
	@Override
	public Object getCredentials() {
		return this.authorities;
	}
	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return this.authenticated;
	}
	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		this.authenticated = isAuthenticated;
	}
    
    

}
