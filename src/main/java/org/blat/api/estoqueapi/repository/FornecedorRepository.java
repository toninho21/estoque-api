package org.blat.api.estoqueapi.repository;

import org.blat.api.estoqueapi.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository  extends JpaRepository<Fornecedor, Long>{
	
	
}
