package com.projeto.apiproducts.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.apiproducts.dto.ReviewDTO;
import com.projeto.apiproducts.entities.Product;
import com.projeto.apiproducts.entities.Review;
import com.projeto.apiproducts.entities.User;
import com.projeto.apiproducts.repositories.ProductRepository;
import com.projeto.apiproducts.repositories.ReviewRepository;
import com.projeto.apiproducts.repositories.UserRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<ReviewDTO> listAll(ReviewDTO dto) {
		List<Review> allReview = repository.findAll();
		return allReview.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		Review review = new Review();
		review.setText(dto.getText());
		
		User user = userRepository.getOne(dto.getUserId());
		review.setUser(user);
		
		Product product = productRepository.getOne(dto.getProductId());
		review.setProduct(product);
		
		review = repository.save(review);
		return new ReviewDTO(review);
	}
	
	
}
