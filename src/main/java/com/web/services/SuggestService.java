package com.web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.models.Suggest;

@Service
public interface SuggestService {

	Suggest save(Suggest suggest);
	
	List<String> findAllSuggestName(int userId);
}
