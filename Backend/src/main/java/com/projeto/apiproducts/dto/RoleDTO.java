package com.projeto.apiproducts.dto;

import java.io.Serializable;

import com.projeto.apiproducts.entities.Role;

public class RoleDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Long id;
	String authority;

	public RoleDTO() {

	}

	public RoleDTO(Long id, String authority) {
		this.id = id;
		this.authority = authority;
	}
	
	public RoleDTO(Role role) {
		id = role.getId();
		authority = role.getAuthority();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
