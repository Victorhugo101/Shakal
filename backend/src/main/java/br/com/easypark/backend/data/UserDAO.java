package br.com.easypark.backend.data;


import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.easypark.backend.model.entity.User;

import java.util.Optional;

public interface UserDAO extends PagingAndSortingRepository<User, Long> {


    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    
}
