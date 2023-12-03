package com.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.models.Cart;
import com.web.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	CartRepository cartRepository;
	
	@Override
	public Cart saveCart(Cart cart) {
		return cartRepository.save(cart);
	}
	
	@Override
	public void deleteByBookId(int bookId) {
		cartRepository.deleteByBookId(bookId);
	}
	
	
	
	@Override
	public List<Integer> findAllBookId(int userId, int num){
		return cartRepository.findAllBookId(userId, num);
	}

	@Override
	public int updateFieldName(int userId) {
		return cartRepository.updateFieldName(userId);
	}

}
