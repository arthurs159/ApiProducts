package com.projeto.apiproducts.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.apiproducts.dto.ReviewDTO;
import com.projeto.apiproducts.services.ReviewService;

@RestController
@RequestMapping(value = "reviews")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@GetMapping
	public ResponseEntity<List<ReviewDTO>> ListAll(ReviewDTO dto){
		List<ReviewDTO> review = service.listAll(dto);
		return ResponseEntity.ok().body(review);
	}
	
	@PostMapping
	public ResponseEntity<ReviewDTO> insert (@RequestBody ReviewDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
