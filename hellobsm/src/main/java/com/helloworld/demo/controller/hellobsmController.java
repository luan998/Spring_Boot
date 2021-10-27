package com.helloworld.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hellobsm")
public class hellobsmController {
	
	@GetMapping
	public  String hellobsm (){
		return "Utilizei a persistência e a mentalidade de atenção aos detalhes para realizar essa tarefa.";
	}

}
