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
	public ResponseEntity<List<Place>> getAll(){
		ResponseEntity<List<Place>> responseEntity
			= placeService.getAll();
		return responseEntity; 
	}
	
	@PostMapping()
	public Place insert(@RequestBody Place place) {
		Place placeReturn = null;
		try {
			placeReturn = placeService.insert(place);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return placeReturn; 
	}
	
	@DeleteMapping("/{id}")
	public Place delete(@PathVariable("id") Integer id) {
		Place place = placeService.delete(id);
		return place; 
	}
	
	@PutMapping
	public Place edit(@RequestBody Place place) {
		Place placeEdit = placeService.edit(place);
		return placeEdit; 
	}
}
