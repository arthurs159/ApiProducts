package com.projeto.apiproducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.apiproducts.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
