package org.blat.api.estoqueapi.repository;

import org.blat.api.estoqueapi.model.Estoquegeral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstoquegeralRepository extends JpaRepository<Estoquegeral, Long> {  

	
}
