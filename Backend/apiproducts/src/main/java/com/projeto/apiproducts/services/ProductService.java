package com.projeto.apiproducts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.apiproducts.dto.ProductDTO;
import com.projeto.apiproducts.entities.Product;
import com.projeto.apiproducts.repositories.ProductRepository;
import com.projeto.apiproducts.services.exception.ResourceNotFoundException;

public class ProductService {

	@Autowired
	ProductRepository repository;
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Optional<Product> product = repository.findById(id);
		Product entity = product.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ProductDTO(entity);
	}
	
	public Page<ProductDTO> findAllPaged(Pageable pageable){
		
	}
	
}
