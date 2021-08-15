package com.arlindo.apiRest.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arlindo.apiRest.dto.FuncionarioDTO;
import com.arlindo.apiRest.model.Funcionario;
import com.arlindo.apiRest.service.FuncionarioService;

@RequestMapping("funcionarios")
@RestController
public class Controller {

	@Autowired
	private FuncionarioService fs;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Funcionario>> getId(){
		System.out.println(fs.listar());

		return ResponseEntity.ok().body(fs.listar());
	}
	
	@GetMapping("/pegaId/{id}")
	public ResponseEntity<Funcionario> getById(@PathVariable long id){
		return ResponseEntity.ok().body(fs.getId(id));
	
	}
	@PostMapping("/salvar")  //aplicando o padrão DTO 2º
	public ResponseEntity<Funcionario> salvar(@Valid @RequestBody FuncionarioDTO funcionariodto){
		Funcionario funcionario = fs.salvar(funcionariodto.transformaDTO());
		return ResponseEntity.ok().body(fs.salvar(funcionario));
		
	}
	@GetMapping("/pegaNome/{nome}")
	public ResponseEntity<Funcionario> pegaNome(@PathVariable String nome){
		return ResponseEntity.ok().body(this.fs.pegaNome(nome));
		
	}
	@GetMapping("/pegaSetor/{setor}")
	public ResponseEntity<Funcionario> pegaSetor(@PathVariable String setor ) {
		return ResponseEntity.ok().body(this.fs.getSetor(setor));
		}
	//PARA DTO
	@GetMapping("/dto")
	public ResponseEntity<List<FuncionarioDTO>> findAll(){
		List<Funcionario> list = fs.findAlll();
		System.out.println(fs.findAlll()+"list funci");
				//converte A LISTA DE FUNCIONADIOS para UMA LISTA DTO
		List<FuncionarioDTO> listDTO = list.stream().map(obj -> new FuncionarioDTO()).collect(Collectors.toList());
		System.out.println(			listDTO.size()+"list DTO");
		
		return ResponseEntity.ok().body(listDTO);
				
	}
}
