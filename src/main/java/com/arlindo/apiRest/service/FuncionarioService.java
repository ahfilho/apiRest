package com.arlindo.apiRest.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arlindo.apiRest.model.Funcionario;
import com.arlindo.apiRest.repository.FuncionarioRepository;

@Transactional
@Service
public class FuncionarioService implements Metodos {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);

	}

	@Override
	public Funcionario atualizar(Funcionario funcionario) {
		Optional<Funcionario> funcionarioDB = this.funcionarioRepository.findById(funcionario.getId());
		if (funcionarioDB.isPresent()) {
			Funcionario func = funcionarioDB.get();
			func.setId(funcionario.getId());
			func.setNome(funcionario.getNome());
			func.setFuncao(funcionario.getFuncao());
			func.setSetor(funcionario.getSetor());
			func.setMatricula(funcionario.getMatricula());
			return func;
		} else {
			System.out.println("ERRO AO ATUALIZAR" + funcionario.getId());
		}
		return funcionario;

	}

	@Override
	public List<Funcionario> listar() {
		return this.funcionarioRepository.findAll();
	}

	@Override
	public Funcionario getId(long id) {
		Optional<Funcionario> funcionarioDB = this.funcionarioRepository.findById(id);
		if (funcionarioDB.isPresent()) {
			System.out.println("SUCESS");
		} else {
			System.out.println("ERRO AO BUSCAR O ID" + id);
		}
		return funcionarioDB.get();

	}

	@Override
	public void deletaFuncionario(long id) {
		Optional<Funcionario> funcionarioDB = this.funcionarioRepository.findById(id);
		if (funcionarioDB.isPresent()) {
			this.funcionarioRepository.delete(funcionarioDB.get());
		} else {
			System.out.println("ERRO AO DELETAR O ID");
		}
	}

	@Override
	public Funcionario pegaNome(String nome) {
		Funcionario funcionarioGetNome = this.funcionarioRepository.findByNome(nome);
		if (funcionarioGetNome != null) {
			return funcionarioGetNome;
		} else {
			System.out.println("ERRO AO BUSCAR PELO NOME");
		}
		return funcionarioGetNome;
	}

	public Funcionario getSetor(String setor) {
		Funcionario funcionarioSetor = this.funcionarioRepository.findBySetor(setor);
		if (funcionarioSetor != null) {
			return funcionarioSetor;
		} else {
			System.out.println("erro na busca por setor");
		}
		return funcionarioSetor;
	}
	// DTO

	public List<Funcionario> findAlll() {
		return funcionarioRepository.findAll();
	}

	@Override
	public Funcionario getMatricula(int matricula) {
		Funcionario funcionarioMatricula = this.funcionarioRepository.findByMatricula(matricula);
		if (funcionarioMatricula != null) {
			System.out.println("matricula encontrada");
		} else {
			System.out.println("Esta matrícula não existe");
		}
		return funcionarioMatricula;
	}

}