package com.solucao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solucao.domain.Place;
import com.solucao.service.PlaceService;

@RestController
@RequestMapping("/place")
public class PlaceController {
	
	@Autowired
	private PlaceService placeService; 
	
	@GetMapping()
	public ResponseEntity<List<Place>> findAll(){
		ResponseEntity<List<Place>> responseEntity
			= placeService.findAll();
		return responseEntity; 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Place> findById(@PathVariable("id") Integer id){
		ResponseEntity<Place> responseEntity
			= placeService.findById(id);
		return responseEntity; 
	}
	
	@GetMapping("/place-by-name/{name}")
	public ResponseEntity<List<Place>> findByName(@PathVariable("name") String name){
		ResponseEntity<List<Place>> responseEntity
			= placeService.findByName(name);
		return responseEntity; 
	}
	
	@GetMapping("/place-by-country/{country}")
	public ResponseEntity<List<Place>> findByCountry(@PathVariable("country") String country){
		ResponseEntity<List<Place>> responseEntity
			= placeService.findByCountry(country);
		return responseEntity; 
	}
	
	@GetMapping("/place-by-state/{state}")
	public ResponseEntity<List<Place>> findByState(@PathVariable("state") String state){
		ResponseEntity<List<Place>> responseEntity
			= placeService.findByState(state);
		return responseEntity; 
	}
	
	@GetMapping("/place-by-city/{city}")
	public ResponseEntity<List<Place>> findByCity(@PathVariable("city") String city){
		ResponseEntity<List<Place>> responseEntity
			= placeService.findByState(city);
		return responseEntity; 
	}
	
	@PostMapping()
	public ResponseEntity<Place> insert(@RequestBody Place place) {
		ResponseEntity<Place> responseEntity = null;
		try {
			responseEntity = placeService.insert(place);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseEntity; 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Place> delete(@PathVariable("id") Integer id) {
		ResponseEntity<Place> placeDeleted = placeService.delete(id);
		return placeDeleted; 
	}
	
	@PutMapping
	public ResponseEntity<Place> edit(@RequestBody Place place) {
		ResponseEntity<Place> placeEdit = placeService.edit(place);
		return placeEdit; 
	}
}
