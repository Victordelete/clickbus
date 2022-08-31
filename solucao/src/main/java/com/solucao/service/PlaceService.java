package com.solucao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.solucao.domain.Place;
import com.solucao.repository.PlaceRepository;

@Service
public class PlaceService {
	
	@Autowired
	private PlaceRepository placeRepository;
	
	public ResponseEntity<List<Place>> getAll(){
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json;");
	    headers.add(HttpHeaders.CONTENT_TYPE, "List of All places stored!");
		List<Place> places = placeRepository.findAll();
		return ResponseEntity.
				status(HttpStatus.OK).
				headers(headers).
				body(places);
	}
	
	public Place insert(Place place) throws Exception {
		Place placeReturn = placeRepository.save(place);
		Optional<Place> placeOptional = Optional.ofNullable(placeReturn);
		if(placeOptional.isEmpty()) {
			throw new Exception();
		}
		return placeOptional.get(); 
	}
	
	public Place delete(Integer id) {
		Optional<Place> placeOptional = placeRepository.findById(id);
		if(!placeOptional.isEmpty()) {
			placeRepository.delete(placeOptional.get());
		}
		Place placeResult = placeOptional.get();
		return placeResult;
	}
	
	//Serviço para EDITAR produtos na farmácia
	public Place edit(Place place) {
		Place placeResult = placeRepository.save(place);
		return placeResult; 
	}
	
}
