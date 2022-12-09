package com.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_tema")
public class Tema {
	
	//primary key , cascade vai mostrar tudo que mostrarna postagem

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@NotNull (message = "O Atributo id e obrigatorio")
	private Long id; 
	
	
	@NotBlank(message = "O Atributo titulo e obrigatorio e nao pode ser vazio") 
	@Size(min = 1, max = 100, message = "O Atributo titulo deve conter no minimo 5 e no maximo 100")
	private String descricao;


	@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;
	
	
	
	public List<Postagem> getPostagem() {
		return postagem;
	}


	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
