package com.web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.models.Cart;

@Service
public interface CartService {

	Cart saveCart(Cart cart);

	void deleteByBookId(int bookId);
	
	List<Integer> findAllBookId(int userId, int num);

	
	
	int updateFieldName(int userId);

}
