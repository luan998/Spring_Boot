package br.com.generation.blogpessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//entity fala que essa classe gera uma tabela no bando de dados
//table informa ao SQL qual o nome da tabela
@Entity
@Table(name = "tb_postagens")
public class Postagem {

	//define que é o id e o auto increment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//mentagem de erro que aparece caso o título não tenha mensagem
	@NotNull(message = "O atributo título é obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo titulo deve conter mais que 5 caracteres e menos que 100.")
	private String titulo;
	
	@NotNull(message = "O atributo texto é obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo titulo deve conter mais que 10 caracteres e menos que 1000.")
	private String texto;
	
	//define a dada e o new mostra até os milisegundos
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
