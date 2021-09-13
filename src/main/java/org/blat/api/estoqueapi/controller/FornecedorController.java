package org.blat.api.estoqueapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.blat.api.estoqueapi.model.Fornecedor;
import org.blat.api.estoqueapi.repository.FornecedorRepository;
import org.blat.api.estoqueapi.service.FornecedorService;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class FornecedorController {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private FornecedorService fornecedorService;

	@GetMapping(value = "/fornecedor")
	public String alo() {
        //TODO
        return "Oi gente, fornecedor no ar";
    }
	
	
	@GetMapping(value = "/fornecedor/lista")
	public List<Fornecedor> get() {
        //TODO
        return fornecedorService.findAll();
    }
	
	@GetMapping(value = "/fornecedor/{codigo}")
	public Optional<Fornecedor> getById(@PathVariable Long codigo) {
        //TODO
        return fornecedorService.findById(codigo);
    }
	
	@PostMapping("/fornecedor/insere")
	@ResponseStatus(HttpStatus.CREATED)
	public Fornecedor adicionar(@Valid @RequestBody Fornecedor forn) throws Exception {
		return fornecedorService.salvar(forn);
	}

	@PutMapping("/fornecedor/{fornecedorId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Fornecedor alterar(@PathVariable Long fornecedorId, @Valid @RequestBody Fornecedor forn) throws Exception {
		
		forn.setFornecedorid(fornecedorId);
		
		return fornecedorService.alterar(forn);
	}
	
	@DeleteMapping("/fornecedor/{fornecedorId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<Void> remover(@PathVariable Long fornecedorId) {
		
		if (!fornecedorRepository.existsById(fornecedorId)) {
			return ResponseEntity.notFound().build();
		}
		
		fornecedorService.excluir(fornecedorId);
		
		return ResponseEntity.noContent().build();
	}

}

