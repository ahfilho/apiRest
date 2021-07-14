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

	public Funcionario salvar(Funcionario funcrionario) {
		return funcionarioRepository.save(funcrionario);

	}

	@Override
	public Funcionario atualizar(Funcionario funcionario) {
		Optional<Funcionario> funcionarioDB = this.funcionarioRepository.findById(funcionario.getId());
		if(funcionarioDB.isPresent()) {
			Funcionario func = funcionarioDB.get();
			func.setId(funcionario.getId());
			func.setNome(funcionario.getNome());
			func.setFuncao(funcionario.getFuncao());
			func.setIdade(funcionario.getIdade());
			return func;
		} else {
			System.out.println("ERRO AO ATUALIZAR"+funcionario.getId());
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
			return funcionarioDB.get();
		} else {
			System.out.println("ERRO AO BUSCAR O ID" + id);
		}

		return null;
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
}