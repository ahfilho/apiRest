package com.arlindo.apiRest.dto;

import com.arlindo.apiRest.model.Funcionario;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RespostaDTO {

	private Long id;
	private String nome;
	private String funcao;
	private String setor;

	public static RespostaDTO transformaDTO(Funcionario funcionario) {
		return new RespostaDTO(funcionario.getId(), funcionario.getNome(), funcionario.getFuncao(),funcionario.getSetor());
	}


}
