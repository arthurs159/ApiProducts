package com.projeto.apiproducts.dto;

import com.projeto.apiproducts.entities.Review;

public class ReviewDTO {

	private Long id;
	private String text;
	private Long productId;
	private Long userId;
	
	public ReviewDTO() {
	}

	public ReviewDTO(Review entity) {
		id = entity.getId();
		text = entity.getText();
		productId = entity.getProduct().getId();
		userId = entity.getUser().getId();
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
