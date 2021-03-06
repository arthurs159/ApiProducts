package com.projeto.apiproducts.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.apiproducts.dto.ReviewDTO;
import com.projeto.apiproducts.entities.Product;
import com.projeto.apiproducts.entities.Review;
import com.projeto.apiproducts.entities.User;
import com.projeto.apiproducts.repositories.ProductRepository;
import com.projeto.apiproducts.repositories.ReviewRepository;
import com.projeto.apiproducts.repositories.UserRepository;
import com.projeto.apiproducts.services.exception.DatabaseException;
import com.projeto.apiproducts.services.exception.ResourceNotFoundException;

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
	
	@Transactional(readOnly = true)
	public ReviewDTO getById(Long id) {
		Optional<Review> review = repository.findById(id);
		Review entity = review.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ReviewDTO(entity);
	}

	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		try {
			Review review = new Review();
			review.setText(dto.getText());

			User user = userRepository.getOne(dto.getUserId());
			review.setUser(user);

			Product product = productRepository.getOne(dto.getProductId());
			review.setProduct(product);

			review = repository.save(review);
			return new ReviewDTO(review);
		} catch(InvalidDataAccessApiUsageException e) {
			throw new ResourceNotFoundException("ID do usu??rio n??o encontrado =( ");

		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(ResourceNotFoundException e) {
			throw new ResourceNotFoundException("ID n??o encontrado =(  id = " + id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException("ID n??o pode ser apagado (Integrity Violation) =(");
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("ID n??o encontrado =(  id = " + id);
		}
	}

}
