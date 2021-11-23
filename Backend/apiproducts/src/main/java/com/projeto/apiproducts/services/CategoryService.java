package com.projeto.apiproducts.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.projeto.apiproducts.dto.CategoryDTO;
import com.projeto.apiproducts.entities.Category;
import com.projeto.apiproducts.repositories.CategoryRepository;
import com.projeto.apiproducts.services.exception.DatabaseException;
import com.projeto.apiproducts.services.exception.ResourceNotFoundException;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository repository;
	
	// find by id / find all / insert/ delete/ update
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> categories = repository.findAll();
		return categories.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> product = repository.findById(id);
		Category entity = product.orElseThrow(() -> new ResourceNotFoundException("Id Não encontrado"));
		return new CategoryDTO(entity);
	}
	
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}
	
	@Transactional
	public CategoryDTO update(Long id, CategoryDTO dto) {
		try {
			Category entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new CategoryDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("ID not found " + id);
		}
	}
	
	@DeleteMapping
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
	
}
