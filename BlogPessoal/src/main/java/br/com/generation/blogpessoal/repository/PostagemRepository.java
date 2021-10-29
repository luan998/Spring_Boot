package br.com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.blogpessoal.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	
	//consultas personalizadas
		public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
		//select * from tb_postagens where titulo like"%titulo%"
	
}