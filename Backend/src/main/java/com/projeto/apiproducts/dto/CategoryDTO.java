package com.projeto.apiproducts.dto;

import java.io.Serializable;

import com.projeto.apiproducts.entities.Category;

public class CategoryDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String url;

	public CategoryDTO() {

	}

	public CategoryDTO(Long id, String name, String url) {
		this.id = id;
		this.name = name;
		this.url = url;
	}

	public CategoryDTO(Category entity) {
		id = entity.getId();
		name = entity.getName();
		url = entity.getUrl();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
