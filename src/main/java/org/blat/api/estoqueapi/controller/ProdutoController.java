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

import org.blat.api.estoqueapi.model.Produto;
import org.blat.api.estoqueapi.repository.ProdutoRepository;
import org.blat.api.estoqueapi.service.ProdutoService;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/produto")
	public String alo() {
        //TODO
        return "Oi gente, produto no ar";
    }
	
	
	@GetMapping(value = "/produto/lista")
	public List<Produto> get() {
        //TODO
        return produtoService.findAll();
    }
	
	@GetMapping(value = "/produto/{codigo}")
	public Optional<Produto> getById(@PathVariable Long codigo) {
        //TODO
        return produtoService.findById(codigo);
    }
	
	@PostMapping("/produto/insere")
	@ResponseStatus(HttpStatus.CREATED)
	public Produto adicionar(@Valid @RequestBody Produto prod) throws Exception {
		return produtoService.salvar(prod);
	}

	@PutMapping("/produto/{produtoId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Produto alterar(@PathVariable Long produtoId, @Valid @RequestBody Produto prod) throws Exception {
		
		prod.setProdutoid(produtoId);
		
		return produtoService.alterar(prod);
	}
	
	@DeleteMapping("/produto/{produtoId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<Void> remover(@PathVariable Long produtoId) {
		
		if (!produtoRepository.existsById(produtoId)) {
			return ResponseEntity.notFound().build();
		}
		
		produtoService.excluir(produtoId);
		
		return ResponseEntity.noContent().build();
	}

}

