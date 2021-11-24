package com.projeto.apiproducts.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.apiproducts.dto.CategoryDTO;
import com.projeto.apiproducts.dto.ProductDTO;
import com.projeto.apiproducts.entities.Category;
import com.projeto.apiproducts.entities.Product;
import com.projeto.apiproducts.repositories.CategoryRepository;
import com.projeto.apiproducts.repositories.ProductRepository;
import com.projeto.apiproducts.services.exception.DatabaseException;
import com.projeto.apiproducts.services.exception.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Optional<Product> product = repository.findById(id);
		Product entity = product.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ProductDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAllPaged(Pageable pageable) {
		Page<Product> page = repository.findAll(pageable);
		return page.map(x -> new ProductDTO(x));
	}
	
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		dtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}
	
	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
		try {
			Product entity = repository.getOne(id);
			dtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ProductDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("ID not found " + id);
		}
	}

	@Transactional
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(ResourceNotFoundException e) {
			throw new ResourceNotFoundException("ID não encontrado =(  id = " + id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException("ID não pode ser apagado (Integrity Violation) =(");
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("ID não encontrado =(  id = " + id);
		}
	}
	
	
	public void dtoToEntity(ProductDTO dto, Product entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setImgUrl(dto.getImgUrl());

		entity.getCategories().clear();

		for (CategoryDTO catDto : dto.getCategories()) {
			Category category = categoryRepository.getOne(catDto.getId());
			entity.getCategories().add(category);
		}
	}
}
