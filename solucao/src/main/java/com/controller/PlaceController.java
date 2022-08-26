package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.PlaceService;


@RestController
@RequestMapping("place")
public class PlaceController {
	//Aciona Service para esta categoria
	@Autowired
	private PlaceService placeService; 
	
	@GetMapping("/welcome")
	public String listar(){
		return "Sauve fiote\n";  
	}
}
