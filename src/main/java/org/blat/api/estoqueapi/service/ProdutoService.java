package org.blat.api.estoqueapi.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.blat.api.estoqueapi.model.Produto;
import org.blat.api.estoqueapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
public class ProdutoService {

	@Autowired
	private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
	
    public List<Produto> findAll() {
		// TODO Auto-generated method stub
		try {
			return (List<Produto>) produtoRepository.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Optional<Produto> findById(Long codigo) {
		// TODO Auto-generated method stub
		return produtoRepository.findById(codigo);
	}

	@Transactional
	public Produto salvar(@Valid Produto prod) throws Exception {
		
		// TODO Auto-generated method stub

		Optional<Produto> produtoJaExiste = produtoRepository.findById(prod.getProdutoid());

		if (!produtoJaExiste.isEmpty()) {
			throw new Exception("Já existe um produto cadastrado com este id.");
		}

		
		return produtoRepository.save(prod);
	}
	
	@Transactional
	public Produto alterar(@Valid Produto prod) throws Exception {
		
		// TODO Auto-generated method stub

		Optional<Produto> produtoJaExiste = produtoRepository.findById(prod.getProdutoid());

		if (!produtoJaExiste.isEmpty()) {
			
			prod.setDescricaoprod(prod.getDescricaoprod());
			prod.setFabricante(prod.getFabricante());
			prod.setNomeprod(prod.getNomeprod());
			prod.setProdutoid(prod.getProdutoid());
			
			return produtoRepository.save(prod);
		}

		throw new Exception("Não foi possível atualizar. Não existe produto cadastrado com este id.");
		
	}

	@Transactional
	public void excluir(Long produtoId) {
		// TODO Auto-generated method stub
		produtoRepository.deleteById(produtoId);
	
	}
}


