package com.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.web.models.Cart;

import jakarta.transaction.Transactional;


public interface CartRepository extends JpaRepository<Cart, Integer>{
	@Query("select c.bookId from Cart c where c.userId = ?1 and c.pay=?2")
	List<Integer> findAllBookId(int userId, int num);
	
	@Modifying
	@Transactional
	@Query("UPDATE Cart e SET e.pay = 0 WHERE e.userId = ?1")
    int updateFieldName(int userId);
	
	@Transactional
    void deleteByBookId(int bookId);
}
