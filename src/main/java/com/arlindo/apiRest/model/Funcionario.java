package com.arlindo.apiRest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@Getter
@NoArgsConstructor
//@AllArgsConstructor
public class Funcionario {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "não pode ser vazio")
	@Column(name = "nome")
	private String nome;

	@NotEmpty(message = "não pode ser nulo")
	@Column
	private String funcao;

	@NotEmpty(message = "não pode ser nulo")
	@Column
	private String setor;

	private int idade;

	//// DTO 3º
	public Funcionario(@NotEmpty(message = "não pode ser vazio") String nome,
			@NotEmpty(message = "não pode ser nulo") String funcao,
			@NotEmpty(message = "não pode ser nulo") String setor) {
		this.nome = nome;
		this.funcao = funcao;
		this.setor = setor;
	}

}
