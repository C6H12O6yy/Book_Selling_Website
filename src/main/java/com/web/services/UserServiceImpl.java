package com.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.models.User;
import com.web.repository.UserReponsitory;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserReponsitory userReponsitory;
	
	@Override
	public User save(User user) {
		return userReponsitory.save(user);
	}

	@Override
	public Optional<User> findById(int id) {
		return userReponsitory.findById(id);
	}

	@Override
	public List<User> findAll() {
		return (List<User>)userReponsitory.findAll();
	}

	@Override
	public void deleteById(int id) {
		userReponsitory.deleteById(id);
	}

	@Override
	public User findByUsername(String username) {
		return userReponsitory.findByUsername(username);
	}
	
	
}
