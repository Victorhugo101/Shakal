package br.com.easypark.backend.initializr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import br.com.easypark.backend.data.CategoriaDAO;
import br.com.easypark.backend.data.ClienteDAO;
import br.com.easypark.backend.data.MesaDAO;
import br.com.easypark.backend.data.PedidoDAO;
import br.com.easypark.backend.data.PedidoProdutoDAO;
import br.com.easypark.backend.data.ProdutoDAO;
import br.com.easypark.backend.data.TruckDAO;
import br.com.easypark.backend.data.UserDAO;
import br.com.easypark.backend.model.entity.Categoria;
import br.com.easypark.backend.model.entity.Cliente;
import br.com.easypark.backend.model.entity.Mesa;
import br.com.easypark.backend.model.entity.Pedido;
import br.com.easypark.backend.model.entity.PedidoProduto;
import br.com.easypark.backend.model.entity.Produto;
import br.com.easypark.backend.model.entity.Truck;
import br.com.easypark.backend.model.entity.User;


@Configuration
public class DataInitializer implements ApplicationRunner {

    private ClienteDAO clienteRepository;
    private TruckDAO truckDao;
    private ProdutoDAO produtoRepository;
    private MesaDAO mesaRepository;
    private PedidoDAO pedidoDao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private CategoriaDAO categoriaDao;
    private PedidoProdutoDAO pedidoProdutoDAO;

    @Autowired
    public DataInitializer(ClienteDAO userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
    		ProdutoDAO produtoRepository, TruckDAO truckDao, MesaDAO mesaRepository, PedidoDAO pedidoDao
    		,CategoriaDAO categoriaDao, PedidoProdutoDAO pedidoProdutoDao) {
        this.clienteRepository = userRepository;
        this.truckDao = truckDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.produtoRepository = produtoRepository;
        this.mesaRepository = mesaRepository;
        this.pedidoDao = pedidoDao;
        this.categoriaDao = categoriaDao;
        this.pedidoProdutoDAO = pedidoProdutoDao;
    }

    @Override
    public void run(ApplicationArguments args) {
    	
        if( !this.clienteRepository.findAll().iterator().hasNext()) {

            String passwordCliente = bCryptPasswordEncoder.encode("123456");
        	Cliente cliente = new Cliente("cliente@gmail.com","teste",passwordCliente);
        	cliente = this.clienteRepository.save(cliente);
        
        	String passwordTruck = bCryptPasswordEncoder.encode("123456");
        	Truck truck = new Truck("10987483672452","Ichiraku's Ramen","siricascudo","truck@gmail.com",
        			passwordTruck,-7.998534,-34.924024);
        	this.truckDao.save(truck);
        	
        	Categoria categoriaJaponesa = new Categoria("Comida Japonesa");
        	Categoria categoriaLanches = new Categoria("Lanches");
        	Categoria categoriaVegetariano = new Categoria("Vegetariano");
        	
        	categoriaJaponesa = this.categoriaDao.save(categoriaJaponesa);
        	categoriaLanches = this.categoriaDao.save(categoriaLanches);
        	categoriaVegetariano = this.categoriaDao.save(categoriaVegetariano);
        	
        
        	
        	List<Categoria> categorias = new ArrayList<Categoria>();
        	categorias.add(categoriaJaponesa);
        	categorias.add(categoriaLanches);
        	categorias.add(categoriaVegetariano);
        	
        	
        	List<Produto> produtos = new ArrayList<Produto>();
        	Produto xcoalho = this.produtoRepository.save(new Produto("X-Coalho",10D,categoriaLanches));
        	produtos.add(xcoalho);
        	
        	Produto pizza = this.produtoRepository.save(new Produto("Pizza de Peperonni",19.90,categoriaLanches));
        	produtos.add(pizza);
        	Produto batata = this.produtoRepository.save(new Produto("Batata frita",5.50,categoriaLanches));
        	produtos.add(batata);

        	Produto temaki = this.produtoRepository.save(new Produto("Temaki",20,categoriaJaponesa));
        	produtos.add(temaki);
        	Produto yakisoba = this.produtoRepository.save(new Produto("Yakisoba",18.90,categoriaJaponesa));
        	produtos.add(yakisoba);
        	Produto lamen = this.produtoRepository.save(new Produto("Lamen",23.50,categoriaJaponesa));
        	produtos.add(lamen);
        	

        	Produto quiche = this.produtoRepository.save(new Produto("Quiche de cebola",12,categoriaVegetariano));
        	produtos.add(quiche);
        	Produto coxinha = this.produtoRepository.save(new Produto("Coxinha de Jaca",6.90,categoriaVegetariano));
        	produtos.add(coxinha);
        	
        	
        	
        	//truck.setProdutos(produtos);
        	
        	
        	Mesa mesa = new Mesa("http://uqr.me/snazzoni/qr/14308",4);
        	mesa.setLatitude(-7.998533);
        	mesa.setLongitude(-34.924023);
        	this.mesaRepository.save(mesa);
        	
        	Pedido pedido = new Pedido(cliente,mesa,truck);
        	
        	this.pedidoDao.save(pedido);
        	
        	PedidoProduto pedidotemaki = new PedidoProduto(temaki, pedido,3);
        	PedidoProduto pedidoCoxinha = new PedidoProduto(coxinha, pedido, 5);
        	
        	
        	this.pedidoProdutoDAO.save(pedidotemaki);
        	this.pedidoProdutoDAO.save(pedidoCoxinha);
        	
        
        	
        	System.out.println("Inserted Empty data");
        	
        }
    }
    
  
   
}
