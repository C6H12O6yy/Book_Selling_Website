package com.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.models.Suggest;

public interface SuggestRepository extends JpaRepository<Suggest, Integer>{
	@Query("select s.suggestName from Suggest s where s.userId = ?1")
	List<String> findAllSuggestName(int userId);
}
