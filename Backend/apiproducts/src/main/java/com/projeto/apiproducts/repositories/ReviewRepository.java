package com.projeto.apiproducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.apiproducts.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	

}
