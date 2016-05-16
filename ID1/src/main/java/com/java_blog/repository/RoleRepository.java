package com.java_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String string);

}
