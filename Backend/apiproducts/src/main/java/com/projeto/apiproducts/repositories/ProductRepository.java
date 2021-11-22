package com.projeto.apiproducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.apiproducts.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
