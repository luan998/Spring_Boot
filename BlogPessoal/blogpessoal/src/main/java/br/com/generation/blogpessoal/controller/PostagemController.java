package br.com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.blogpessoal.model.Postagem;
import br.com.generation.blogpessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*",allowedHeaders = "*") //crossorigin permite o front end acessar ao backend
public class PostagemController {
//o Cross origin libera requisições de qualquer origem para o back e o front estarem em locais diferentes
	
	@Autowired
	private PostagemRepository  postagemRepository;
	
	@GetMapping //vai pegar tudo da postagem e rodar numa lista tipo array
	public ResponseEntity <List<Postagem>> getAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
		//select * from tb_postagens; /\/\/\
	}
	
}
