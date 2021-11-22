package com.projeto.apiproducts.dto;

import com.projeto.apiproducts.entities.Review;

public class ReviewDTO {

	private Long id;
	private String text;
	private Long productId;
	private UserDTO user;
	
	public ReviewDTO() {
	}

	public ReviewDTO(Review entity) {
		id = entity.getId();
		text = entity.getText();
		productId = entity.getProduct().getId();
		user = new UserDTO(entity.getUser());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
