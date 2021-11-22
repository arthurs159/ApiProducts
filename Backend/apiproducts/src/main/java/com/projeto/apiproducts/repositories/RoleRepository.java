package com.projeto.apiproducts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.apiproducts.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
