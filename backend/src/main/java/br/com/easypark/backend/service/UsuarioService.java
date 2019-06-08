package br.com.easypark.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.BadCredentialsException;

import br.com.easypark.backend.data.ClienteDAO;
import br.com.easypark.backend.data.UserDAO;
import br.com.easypark.backend.model.dto.ClienteCadastroDTO;
import br.com.easypark.backend.model.dto.LoginDTO;
import br.com.easypark.backend.model.entity.Cliente;
import br.com.easypark.backend.utils.Messages;

@Service
public class UsuarioService  implements UserDetailsService{
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private ClienteDAO clienteDao;
	
	
	
	public Boolean cadastrarCliente(ClienteCadastroDTO cliente) {
		
		Cliente c = new Cliente(cliente.getNome(),cliente.getEmail(),cliente.getSenha());
		clienteDao.save(c);
		return true;
		
	}
	
	
	public ClienteCadastroDTO logar(LoginDTO login) {
		for(Cliente c: clienteDao.findAll()) {
			if(c.getEmail().contains(login.getEmail())){
				if(c.getPassword().equals(login.getSenha()))
					return new ClienteCadastroDTO(c.getId(),c.getUsername(),c.getEmail());
			}
		}
		return new ClienteCadastroDTO(-1L,"","");
	}
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return this.userDao.findByUsername(username)
                .orElseThrow(() -> new BadCredentialsException(Messages.USER_NOT_FOUND));
    }
	
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {

        return this.userDao.findByEmail(email)
                .orElseThrow(() -> new BadCredentialsException(Messages.USER_NOT_FOUND));
    }
}
