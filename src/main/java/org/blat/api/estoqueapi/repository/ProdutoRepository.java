package org.blat.api.estoqueapi.repository;

import org.blat.api.estoqueapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Long>{
	
	
}
