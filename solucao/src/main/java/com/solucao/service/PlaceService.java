package com.solucao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solucao.domain.Place;
import com.solucao.repository.PlaceRepository;

@Service
public class PlaceService {
	
	@Autowired
	private PlaceRepository placeRepository;
	
	public List<Place> list(){
		List<Place> Places = placeRepository.findAll();
		return Places; 
	}
	
	public Place insert(Place place) throws Exception {
		Place placeReturn = placeRepository.save(place);
		Optional<Place> placeOptional = Optional.ofNullable(placeReturn);
		if(placeOptional.isEmpty()) {
			throw new Exception();
		}
		
		return placeOptional.get(); 
	}
}
