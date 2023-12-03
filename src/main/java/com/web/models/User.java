package com.web.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")	
	private int id;
	
	@Column(name = "username", unique=true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private Integer phone;
	
	@Column(name = "gender")
	private boolean gender;

	@Column(name = "role")
	private String role;
	
	public User() {
		super();
	}

	public User(int id, String username, String password, String fullname, Integer age, String address, Integer phone,
			boolean gender, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.role = role;
	}

	public User(String username, String password, String fullname, Integer age, String address, Integer phone,
			boolean gender, String role) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	
	
	
}
