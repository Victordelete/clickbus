package com.solucao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class teste {
	
	@GetMapping("/welcome")
	public String fTeste() {
		return 	"okokokokokokok\n";
	}

}
