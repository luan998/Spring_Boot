package br.com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//Mostra por id na página o resultado do id, se ele não existe não mostra nada, se sim mostra o id
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable long id) {
		return postagemRepository.findById(id).
				map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}") //nome do titulo e da variavel para saber qual parametro passa(entre chaves)
	public ResponseEntity <List<Postagem>> getByTitulo(@PathVariable String titulo){ 
		
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping								//pega o corpo da requisição e transforma no tipo postagem
	public ResponseEntity<Postagem> postPostagem(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
	
		
	}
	
	@PutMapping								
	public ResponseEntity<Postagem> putPostagem(@RequestBody Postagem postagem){
		return postagemRepository.findById(postagem.getId())
				.map(resposta -> ResponseEntity.ok(postagemRepository.save(postagem)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePostagem(@PathVariable long id) {
		return postagemRepository.findById(id)
		.map(resposta-> {
			postagemRepository.deleteById(id);
			return ResponseEntity.ok().build();
		})
		.orElse(ResponseEntity.notFound().build());
	}
	
}
