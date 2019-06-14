package br.com.easypark.backend.model.entity;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    private String email;

    @NotEmpty
    @Column(nullable = false)
    private String username;

    @NotEmpty
    @Column(nullable = false)
    private String password;


    @Column( nullable = false)
    private Boolean activated;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER )
    @JoinTable(name = "mtm_user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private  Collection<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    
    public User() {}
    
    
    public User(String email, String username,String password, boolean enabled) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.activated = enabled;
	}


	@Override
    public boolean isAccountNonExpired() {
        return activated;
    }

    @Override
    public boolean isAccountNonLocked() {
        return activated;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return activated;
    }

    @Override
    public boolean isEnabled() {
        return activated;
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
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
	public void setEnabled(boolean enabled) {
		this.activated = enabled;
	}

	

	


	public Collection<Role> getRoles() {
		return roles;
	}


	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
