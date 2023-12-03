package com.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.models.Book;
import com.web.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public void saveBook(Book theBook) {
		bookRepository.save(theBook);
	}

	@Override
	public List<Book> getBookList() {
		
		List<Book> theBook=bookRepository.findAll();
		return theBook;
	}

	@Override
	public Book getBook(int BookNo) {
		
		Optional<Book> result=bookRepository.findById(BookNo);
		Book theBook = null;
		if(result.isPresent()) {
			theBook=result.get();
		}
		else {
			throw new RuntimeException("Không tìm thấy sách");
		}
		return theBook;
	}
	@Override
	public void deleteById(Integer id) {
		bookRepository.deleteById(id);
	}
	
	@Override
	public List<Book> findAllById(List<Integer> id) {
		return bookRepository.findAllById(id);
	}
	
	@Override
	public List<Book> findByBookAuthorIn(List<String> sugget){
		return bookRepository.findByBookAuthorIn(sugget);
	}

	@Override
	public List<Book> findByBookType(String bookType) {
		return bookRepository.findByBookType(bookType);
	}
	@Override
	public String getBookType(int bookTypeId) {
	    switch (bookTypeId) {
	        case 1:
	            return "Văn Học";
	        case 2:
	            return "Khoa Học và Kiến Thức";
	        case 3:
	            return "Nghệ Thuật và Âm Nhạc";
	        case 4:
	            return "Du Lịch và Phiêu Lưu";
	        case 5:
	            return "Sách Thiếu Nhi";
	        case 6:
	            return "Sách Kỹ Năng Sống";
	        case 7:
	            return "Lịch Sử và Chính Trị";
	        case 8:
	            return "Sách Học Ngoại Ngữ";
	        default:
	            return "Văn Học";
	    }
	}

	@Override
	public List<Book> findByBookNameIn(List<String> bookName) {
		return bookRepository.findByBookNameIn(bookName);
	}
}
