package com.web.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Suggest")
public class Suggest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="suggestId")
	private int suggestId;
	
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "suggestName")
	private String suggestName;

	public Suggest() {
		super();
	}

	public Suggest(int suggestId, int userId, String suggestName) {
		super();
		this.suggestId = suggestId;
		this.userId = userId;
		this.suggestName = suggestName;
	}
	
	public Suggest(int userId, String suggestName) {
		super();
		this.userId = userId;
		this.suggestName = suggestName;
	}

	public int getSuggestId() {
		return suggestId;
	}

	public void setSuggestId(int suggestId) {
		this.suggestId = suggestId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSuggestName() {
		return suggestName;
	}

	public void setSuggestName(String suggestName) {
		this.suggestName = suggestName;
	}
	
	
}
