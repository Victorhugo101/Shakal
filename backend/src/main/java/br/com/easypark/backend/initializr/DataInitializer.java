package br.com.easypark.backend.initializr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.easypark.backend.data.UserDAO;
import br.com.easypark.backend.model.entity.User;


@Configuration
public class DataInitializer implements ApplicationRunner {

    private UserDAO userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DataInitializer(UserDAO userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {
    	
        String password = bCryptPasswordEncoder.encode("123456");
        if( !this.userRepository.findAll().iterator().hasNext()) {
        	System.out.println("Inserted Empty data");
        	this.userRepository.save(new User("teste@gmail.com","teste",password,true));
        }
        
    }
}
