package com.projeto.apiproducts.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.apiproducts.dto.RoleDTO;
import com.projeto.apiproducts.dto.UserDTO;
import com.projeto.apiproducts.entities.Role;
import com.projeto.apiproducts.entities.User;
import com.projeto.apiproducts.repositories.RoleRepository;
import com.projeto.apiproducts.repositories.UserRepository;
import com.projeto.apiproducts.services.exception.DatabaseException;
import com.projeto.apiproducts.services.exception.ResourceNotFoundException;
import com.projeto.apiproducts.services.exception.ConstraintViolation;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> user = repository.findAll();
		return user.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> user = repository.findById(id);
		User entity = user.orElseThrow(() -> new ResourceNotFoundException("Id Não encontrado"));
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		dtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		try {
			User entity = repository.getOne(id);
			dtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new UserDTO(entity);
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
		}catch(ConstraintViolationException e) {
			throw new ConstraintViolation("ID não pode ser apagado pois existem items ligados a ela");
	}
}
	
	public void dtoToEntity(UserDTO dto, User entity) {
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		
		entity.getRoles().clear();

		for (RoleDTO cDto : dto.getRoles()) {
			Role roles = roleRepository.getOne(cDto.getId());
			entity.getRoles().add(roles);
		}
	}
}
