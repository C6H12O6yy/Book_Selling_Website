package com.web.models;

import java.util.Arrays;

import jakarta.persistence.*;


@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bookId")
	private int bookId;
	
	@Column(name="bookName")
	private String bookName;
	
	@Column(name="bookType")
	private String bookType;
	
	@Column(name="bookAuthor")
	private String bookAuthor;
	
	@Column(name="bookQuantity")
	private int bookQuantity;
	
	@Column(name="bookPrice")
	private Long bookPrice;
	
	@Column(name="bookDescription", length = 1000)
	private String bookDescription;
	
	@Lob
	@Column(name="bookImage", length = 17000000)
	private byte[] bookImage;

	public Book() {
		super();
	}

	public Book(int bookId, String bookName, String bookType, String bookAuthor, int bookQuantity, Long bookPrice,
			String bookDescription, byte[] bookImage) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookType = bookType;
		this.bookAuthor = bookAuthor;
		this.bookQuantity = bookQuantity;
		this.bookPrice = bookPrice;
		this.bookDescription = bookDescription;
		this.bookImage = bookImage;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getBookQuantity() {
		return bookQuantity;
	}

	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}

	public Long getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Long bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public byte[] getBookImage() {
		return bookImage;
	}

	public void setBookImage(byte[] bookImage) {
		this.bookImage = bookImage;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookType=" + bookType + ", bookAuthor="
				+ bookAuthor + ", bookQuantity=" + bookQuantity + ", bookPrice=" + bookPrice + ", bookDescription="
				+ bookDescription + ", bookImage=" + Arrays.toString(bookImage) + "]";
	}


	
}
