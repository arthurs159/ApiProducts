package com.projeto.apiproducts.services.exception;

public class ConstraintViolation extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConstraintViolation(String msg) {
		super(msg);
	}
}