package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.PlaceRepository;

@Service
public class PlaceService {
	
	@Autowired
	private PlaceRepository placeRepository;
}
