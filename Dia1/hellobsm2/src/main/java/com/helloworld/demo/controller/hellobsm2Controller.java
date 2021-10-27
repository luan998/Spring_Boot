package com.helloworld.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hellobsm2")
public class hellobsm2Controller {
	
	@GetMapping
	public String hellobsm2() {
		return "Tenho como objetivo de aprendizagem desta semana, dominar o spring boot e iniciar meus projetos nesse programa.";
	}
	
}
