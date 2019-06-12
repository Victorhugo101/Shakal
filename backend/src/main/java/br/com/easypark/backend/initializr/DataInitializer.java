package br.com.easypark.backend.initializr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.easypark.backend.data.ClienteDAO;
import br.com.easypark.backend.data.ProdutoDAO;
import br.com.easypark.backend.data.TruckDAO;
import br.com.easypark.backend.data.UserDAO;
import br.com.easypark.backend.model.entity.Categoria;
import br.com.easypark.backend.model.entity.Cliente;
import br.com.easypark.backend.model.entity.Produto;
import br.com.easypark.backend.model.entity.Truck;
import br.com.easypark.backend.model.entity.User;


@Configuration
public class DataInitializer implements ApplicationRunner {

    private ClienteDAO clienteRepository;
    private TruckDAO truckDao;
    private ProdutoDAO produtoRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DataInitializer(ClienteDAO userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
    		ProdutoDAO produtoRepository, TruckDAO truckDao) {
        this.clienteRepository = userRepository;
        this.truckDao = truckDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
    	
        String passwordCliente = bCryptPasswordEncoder.encode("123456");
        if( !this.clienteRepository.findAll().iterator().hasNext()) {
        	this.clienteRepository.save(new Cliente("cliente@gmail.com","teste",passwordCliente));
        }
        String passwordTruck = bCryptPasswordEncoder.encode("123456");
       
        if(!this.produtoRepository.findAll().iterator().hasNext()) {
        	List<Produto> produtos = new ArrayList<Produto>();
        	produtos.add(new Produto("Hamburger de Siri",10D,new Categoria()));
        	produtos.add(new Produto("Suco de Laranja",10D,new Categoria()));
        	produtos.add(new Produto("Batata frita",10D,new Categoria()));
        	
        	Truck truck = new Truck("10987483672452","Siri Cascudo","truck@gmail.com",
        			passwordTruck,1.0989478D,0.874772637D);
        	this.truckDao.save(truck);
        	
        }
        System.out.println("Inserted Empty data");
        
    }
   
}
