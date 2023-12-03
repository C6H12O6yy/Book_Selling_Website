package com.web.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderId")
	private int orderId;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "userPhone")
	private int userPhone;
	
	@Column(name = "userAddress")
	private String userAddress;
	
	@Column(name = "orderStatus")
	private int orderStatus;
	
	@Column(name = "orderName")
	private String orderName;
	
	@Column(name = "orderDate")
	private LocalDate orderDate;
	
	@Column(name = "sumPrice")
	private Long sumPrice;
	
	@Column(name = "userId")
	private int userId;
	
	public Orders() {
		super();
	}

	public Orders(int orderId, int userId, String userName, int userPhone, String userAddress, int orderStatus,
			String orderName, LocalDate orderDate, Long sumPrice) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.orderStatus = orderStatus;
		this.orderName = orderName;
		this.orderDate = orderDate;
		this.sumPrice = sumPrice;
	}

	public Orders(int userId, String userName, int userPhone, String userAddress, int orderStatus, String orderName,
			LocalDate orderDate, Long sumPrice) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.orderStatus = orderStatus;
		this.orderName = orderName;
		this.orderDate = orderDate;
		this.sumPrice = sumPrice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Long getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Long sumPrice) {
		this.sumPrice = sumPrice;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", userId=" + userId + ", userName=" + userName + ", userPhone="
				+ userPhone + ", userAddress=" + userAddress + ", orderStatus=" + orderStatus + ", orderName="
				+ orderName + ", orderDate=" + orderDate + ", sumPrice=" + sumPrice + "]";
	}

	
	
	
}
