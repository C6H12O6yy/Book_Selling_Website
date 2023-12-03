package com.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
    List<Book> findByBookAuthorIn(List<String> suggest);
    
    List<Book> findByBookNameIn(List<String> bookName);
    
    List<Book> findByBookType(String bookType);
    
    
}
