package org.blat.api.estoqueapi.service;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.blat.api.estoqueapi.model.Estoquegeral;
import org.blat.api.estoqueapi.repository.EstoquegeralRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class EstoquegeralService {
    
	@Autowired
	private final EstoquegeralRepository estoquegeralRepository;
	
    public EstoquegeralService(EstoquegeralRepository estoquegeralRepository) {
        this.estoquegeralRepository = estoquegeralRepository;
    }

	public List<Estoquegeral> findAll() {
		// TODO Auto-generated method stub
		return estoquegeralRepository.findAll();
	}

}






