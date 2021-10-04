package com.arlindo.apiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arlindo.apiRest.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	public Funcionario findByNome(String nome);

	public Funcionario findBySetor(String setor);

	public Funcionario findByMatricula(int matricula);

}

/*
 * projeto spring boot controllers services requisições http json padrão dto
 * teste com postman biblioteca validation
 */