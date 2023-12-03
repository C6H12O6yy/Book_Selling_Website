package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web.models.User;


public interface UserReponsitory extends JpaRepository<User, Integer>{
	User findByUsername(String username); 
}
