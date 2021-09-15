package com.arlindo.apiRest.service;

import java.util.List;

import com.arlindo.apiRest.model.Funcionario;

public interface Metodos {

	Funcionario salvar(Funcionario funcionario);
	Funcionario atualizar(Funcionario funcionario);
	List<Funcionario> listar();
	Funcionario getId(long id);
	void deletaFuncionario(long id);
	Funcionario pegaNome(String nome);
	Funcionario getSetor(String setor);
	Funcionario getMatricula(int matricula);
}
