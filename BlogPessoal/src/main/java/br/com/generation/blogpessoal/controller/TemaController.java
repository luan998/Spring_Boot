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

import br.com.generation.blogpessoal.model.Tema;
import br.com.generation.blogpessoal.repository.TemaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") // * = tudo
@RequestMapping("/tema")
public class TemaController {
	
	@Autowired 
	private TemaRepository temaRepository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> getAll(){
		return ResponseEntity.ok(temaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById(@PathVariable long id){
		return temaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Tema>> getByName(String nome){
		return ResponseEntity.ok(temaRepository.findAllByDescricaoContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Tema> postTema (@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(temaRepository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema> putTema (@RequestBody Tema tema){
		return temaRepository.findById(tema.getId())
				.map(resposta -> ResponseEntity.ok(temaRepository.save(tema))
				)
				.orElse(ResponseEntity.notFound().build());
 	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTema(@PathVariable long id){
		return temaRepository.findById(id)
				.map(resposta-> {
					temaRepository.deleteById(id);
					return ResponseEntity.ok().build();
				})
			.orElse(ResponseEntity.notFound().build());
	}
	
}
