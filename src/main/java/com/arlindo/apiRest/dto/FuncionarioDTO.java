package com.arlindo.apiRest.dto;

import java.io.Serializable;

import com.arlindo.apiRest.model.Funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
public class FuncionarioDTO implements Serializable {

	// aplicando o padrão DTO 1º
	private static final long serialVersionUID = 1L;
	//private Long id;
	private String nome;
	private String funcao;
	private String setor;


	public Funcionario transformaDTO() {
			// passo apenas os atributos que forem necessários. Por exemplo, não passei a idade, pois nao é importante.
		return new Funcionario(nome,funcao,setor);
		
	}
	
	
}