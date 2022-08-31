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
	
	/*
	 * Service to list all places saved. 
	 * 
	 * Parameter: null
	 * 
	 * Return: ResponseEntity<List<Place>>
	 */
	public ResponseEntity<List<Place>> findAll(){
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json;");
	    headers.add(HttpHeaders.CONTENT_TYPE, "List of All places stored!");
		List<Place> places = placeRepository.findAll();
		return ResponseEntity.
				status(HttpStatus.OK).
				headers(headers).
				body(places);
	}
	
	/*
	 * Service to find a place by id 
	 * 
	 * Parameter: Integer id
	 * 
	 * Return: ResponseEntity<Place>
	 */
	public ResponseEntity<Place> findById(Integer id) {
		HttpHeaders header = new HttpHeaders(); 
		header.add(HttpHeaders.CONTENT_TYPE, "application/json;");
	    header.add(HttpHeaders.CONTENT_TYPE, "Find place by id!");
	    
	    //Entity will always be correct. Never null.. 
		Optional<Place> placeOptional = placeRepository.findById(id);
		
		if(placeOptional.isEmpty()) {
			//In case the place wasnt found 
			return ResponseEntity.
					status(HttpStatus.NOT_FOUND).
					headers(header).
					body(placeOptional.get()); 
		}
		
		return ResponseEntity.
			status(HttpStatus.FOUND).
			headers(header).
			body(placeOptional.get()); 
	}
	
	/*
	 * Service to find a place by name 
	 * 
	 * Parameter: String name
	 * 
	 * Return: ResponseEntity<Place>
	 */
	public ResponseEntity<List<Place>> findByName(String name) {
		HttpHeaders header = new HttpHeaders(); 
		header.add(HttpHeaders.CONTENT_TYPE, "application/json;");
	    header.add(HttpHeaders.CONTENT_TYPE, "Find place by name!");
	    
	    //Entity will always be correct. Never null.. 
		Optional<List<Place>> placeOptional = placeRepository.findByName(name);
		
		if(placeOptional.isEmpty()) {
			//In case the place wasnt found 
			return ResponseEntity.
					status(HttpStatus.NOT_FOUND).
					headers(header).
					body(placeOptional.get()); 
		}
		
		return ResponseEntity.
			status(HttpStatus.FOUND).
			headers(header).
			body(placeOptional.get()); 
	}
	
	/*
	 * Service to find a place by country 
	 * 
	 * Parameter: String country
	 * 
	 * Return: ResponseEntity<Place>
	 */
	public ResponseEntity<List<Place>> findByCountry(String country) {
		HttpHeaders header = new HttpHeaders(); 
		header.add(HttpHeaders.CONTENT_TYPE, "application/json;");
	    header.add(HttpHeaders.CONTENT_TYPE, "Find place by country!");
	    
	    //Entity will always be correct. Never null.. 
		Optional<List<Place>> placeOptional = placeRepository.findByCountry(country);
		
		if(placeOptional.isEmpty()) {
			//In case the place wasnt found 
			return ResponseEntity.
					status(HttpStatus.NOT_FOUND).
					headers(header).
					body(placeOptional.get()); 
		}
		
		return ResponseEntity.
			status(HttpStatus.FOUND).
			headers(header).
			body(placeOptional.get()); 
	}
	
	/*
	 * Service to find a place by state 
	 * 
	 * Parameter: String state
	 * 
	 * Return: ResponseEntity<Place>
	 */
	public ResponseEntity<List<Place>> findByState(String state) {
		HttpHeaders header = new HttpHeaders(); 
		header.add(HttpHeaders.CONTENT_TYPE, "application/json;");
	    header.add(HttpHeaders.CONTENT_TYPE, "Find place by state!");
	    
	    //Entity will always be correct. Never null.. 
		Optional<List<Place>> placeOptional = placeRepository.findByCountry(state);
		
		if(placeOptional.isEmpty()) {
			//In case the place wasnt found 
			return ResponseEntity.
					status(HttpStatus.NOT_FOUND).
					headers(header).
					body(placeOptional.get()); 
		}
		
		return ResponseEntity.
			status(HttpStatus.FOUND).
			headers(header).
			body(placeOptional.get()); 
	}
	
	/*
	 * Service to find a place by city 
	 * 
	 * Parameter: String city
	 * 
	 * Return: ResponseEntity<Place>
	 */
	public ResponseEntity<List<Place>> findByCity(String city) {
		HttpHeaders header = new HttpHeaders(); 
		header.add(HttpHeaders.CONTENT_TYPE, "application/json;");
	    header.add(HttpHeaders.CONTENT_TYPE, "Find place by city!");
	    
	    //Entity will always be correct. Never null.. 
		Optional<List<Place>> placeOptional = placeRepository.findByCountry(city);
		
		if(placeOptional.isEmpty()) {
			//In case the place wasnt found 
			return ResponseEntity.
					status(HttpStatus.NOT_FOUND).
					headers(header).
					body(placeOptional.get()); 
		}
		
		return ResponseEntity.
			status(HttpStatus.FOUND).
			headers(header).
			body(placeOptional.get()); 
	}
	
	/*
	 * Service to insert a new Place. 
	 * 
	 * Parameter: Place place. 
	 * 
	 * Return: ResponseEntity<Place>
	 */
	public ResponseEntity<Place> insert(Place place) {
		HttpHeaders header = new HttpHeaders(); 
		header.add(HttpHeaders.CONTENT_TYPE, "application/json;");
	    header.add(HttpHeaders.CONTENT_TYPE, "Insert of new place!");
	    
	    //Entity will always be correct. Never null.. 
		Place placeReturn = placeRepository.save(place);
		
		return ResponseEntity.
			status(HttpStatus.CREATED).
			headers(header).
			body(placeReturn); 
	}
	
	/*
	 * Service to delete a saved Place. 
	 * 
	 * Parameter: Integer id. 
	 * 
	 * Return: ResponseEntity<Place>
	 */
	public ResponseEntity<Place> delete(Integer id) {
		HttpHeaders header = new HttpHeaders(); 
		header.add(HttpHeaders.CONTENT_TYPE, "application/json;");
	    header.add(HttpHeaders.CONTENT_TYPE, "Delete of saved place!");
		
		Optional<Place> placeOptional = placeRepository.findById(id);
		if(!placeOptional.isEmpty()) {
			//In case the place wasnt found
			//////throw new IllegalArgumentException(); 
			return ResponseEntity.
					status(HttpStatus.NOT_FOUND).
					headers(header).
					body(placeOptional.get()); 
		}
		//In case the place was found and deleted with sucess. 
		return ResponseEntity.
				status(HttpStatus.NOT_FOUND).
				headers(header).
				body(placeOptional.get());
	}
	
	/*
	 * Service to edit a place. 
	 * 
	 * Parameter: Place place. 
	 * 
	 * Return: ResponseEntity<Place>
	 */ 
	public ResponseEntity<Place> edit(Place place) {
		HttpHeaders header = new HttpHeaders(); 
		header.add(HttpHeaders.CONTENT_TYPE, "application/json;");
	    header.add(HttpHeaders.CONTENT_TYPE, "Edit of a place!");
	     
		Place placeEdit = placeRepository.save(place);
		return  ResponseEntity.
				status(HttpStatus.OK).
				headers(header).
				body(placeEdit); 
	}
	
}
