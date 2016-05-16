package com.java_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;




import com.java.entity.User_u;

public interface UserRepository extends JpaRepository<User_u, Integer> {

	User_u findByName(String id);


}
