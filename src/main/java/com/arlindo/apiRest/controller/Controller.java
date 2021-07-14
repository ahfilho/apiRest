package com.arlindo.apiRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arlindo.apiRest.model.Funcionario;
import com.arlindo.apiRest.service.FuncionarioService;

@RestController
public class Controller {

	@Autowired
	private FuncionarioService fs;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Funcionario>> getId(){
		return ResponseEntity.ok().body(fs.listar());
	}
	
	@GetMapping("/pegaId/{id}")
	public ResponseEntity<Funcionario> getById(@PathVariable long id){
		return ResponseEntity.ok().body(fs.getId(id));
	
	}
	@PostMapping("/salvar")
	public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario){
		return ResponseEntity.ok().body(this.fs.salvar(funcionario));
	}
}
