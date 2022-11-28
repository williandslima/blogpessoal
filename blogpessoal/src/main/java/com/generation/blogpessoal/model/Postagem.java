package com.generation.blogpessoal.model;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// criando em segundo lugar o model, privates. atributos para postagem + 
// get e set depos, sem construtor

// converter os itens em dados no banco de dados

//classe modeladora para gerar a tabela no banco entity .. create tabela
//as duas anotacoes abaixo faz o create table no banco de dados

@Entity
@Table(name = "tb_postagens")
public class Postagem {
	
	// atributos da tabela
	
	// anotacao para o atributo
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id gerar automatico
	@NotNull (message = "O Atributo id e obrigatorio")
	private Long id; //jpa por padrao usa no id o Long com l M
	
	
	@NotBlank(message = "O Atributo titulo e obrigatorio e nao pode ser vazio") //not NULL nem em branco
	@Size(min = 5, max = 100, message = "O Atributo titulo deve conter no minimo 5 e no maximo 100")
	private String titulo;
	
	@NotNull(message = "O Atributo titulo e obrigatorio") //not NULL
	@Size(min = 10, max = 1000, message = "O Atributo titulo deve conter no minimo 10 e no maximo 1000")
	private String texto;
	
	
	@UpdateTimestamp // data set
	private LocalDateTime data;
	//
	
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	@NotNull (message = "Colocar o id do TEMA - Não pode ficar sem tema !!!")
	//@NotBlank (message = "Nao pode ficar em branco")
	private Tema tema;
	
	
	///criar atributo do tema @manytoone
	
	// habito de cada linha salvar o arqui
	
	// get and sets
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	

}
