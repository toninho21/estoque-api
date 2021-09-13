package org.blat.api.estoqueapi.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.blat.api.estoqueapi.model.Fornecedor;
import org.blat.api.estoqueapi.model.Produto;
import org.blat.api.estoqueapi.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FornecedorService {

	@Autowired
	private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }
	
    public List<Fornecedor> findAll() {
		// TODO Auto-generated method stub
		try {
			return (List<Fornecedor>) fornecedorRepository.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Optional<Fornecedor> findById(Long codigo) {
		// TODO Auto-generated method stub
		return fornecedorRepository.findById(codigo);
	}

	@Transactional
	public Fornecedor salvar(@Valid Fornecedor forn) throws Exception {
		
		// TODO Auto-generated method stub

		Optional<Fornecedor> fornecedorJaExiste = fornecedorRepository.findById(forn.getFornecedorid());

		if (!fornecedorJaExiste.isEmpty()) {
			throw new Exception("Já existe um fornecedor cadastrado com este id.");
		}

		
		return fornecedorRepository.save(forn);
	}
	
	@Transactional
	public Fornecedor alterar(@Valid Fornecedor forn) throws Exception {
		
		// TODO Auto-generated method stub

		Optional<Fornecedor> fornecedorJaExiste = fornecedorRepository.findById(forn.getFornecedorid());

		if (!fornecedorJaExiste.isEmpty()) {
			
			
			forn.setRatingfornec(forn.getRatingfornec());
			forn.setNomefornec(forn.getNomefornec());
			forn.setFornecedorid(forn.getFornecedorid());
			
			return fornecedorRepository.save(forn);
		}

		throw new Exception("Não foi possível atualizar. Não existe fornecedor cadastrado com este id.");
		
	}

	@Transactional
	public void excluir(Long fornecedorId) {
		// TODO Auto-generated method stub
		fornecedorRepository.deleteById(fornecedorId);
	
	}
}


