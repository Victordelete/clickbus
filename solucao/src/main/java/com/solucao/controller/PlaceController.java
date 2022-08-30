package com.solucao.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/welcome")
	public String welcome(){
		return "Welcome"; 
	}
	
	@GetMapping()
	public List<Place> listar(){
		List<Place> places = placeService.list();
		return places; 
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
	
	
}
