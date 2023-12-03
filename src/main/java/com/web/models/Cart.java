package com.web.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Cart")
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cartId")
	private int cartId;
	
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "bookId")
	private int bookId;
	
	@Column(name = "pay")
	private int pay;
	
	public Cart() {
		super();
	}

	public Cart(int cartId, int userId, int bookId, int pay) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.bookId = bookId;
		this.pay = pay;
	}

	public Cart(int userId, int bookId, int pay) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.pay = pay;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	
	

	
	
	
	
}
