package com.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.web.models.User;
@Service
public interface UserService {
	void deleteById(int id);

	List<User> findAll();

	Optional<User> findById(int id);

	User save(User entity);
	
	User findByUsername(String username);
}
