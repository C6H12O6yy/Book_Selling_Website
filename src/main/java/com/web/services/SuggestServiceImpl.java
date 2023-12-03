package com.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.models.Suggest;
import com.web.repository.SuggestRepository;

@Service
public class SuggestServiceImpl implements SuggestService{
	@Autowired
	SuggestRepository suggestRepository;
	
	@Override
	public Suggest save(Suggest suggest) {
		return suggestRepository.save(suggest);
	}

	@Override
	public List<String> findAllSuggestName(int userId) {
		return suggestRepository.findAllSuggestName(userId);
	}
	
}
