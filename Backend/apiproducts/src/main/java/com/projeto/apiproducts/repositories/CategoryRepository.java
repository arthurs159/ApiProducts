package com.projeto.apiproducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.apiproducts.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
