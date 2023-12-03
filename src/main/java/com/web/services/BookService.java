package com.web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.models.Book;

@Service
public interface BookService {

	void saveBook(Book theRoom);

	Book getBook(int BookNo);

	List<Book> getBookList();

	void deleteById(Integer id);

	List<Book> findAllById(List<Integer> id);

	List<Book> findByBookAuthorIn(List<String> sugget);
	
	List<Book> findByBookType(String bookType);

	String getBookType(int bookTypeId);
	
	List<Book> findByBookNameIn(List<String> bookName);
}
