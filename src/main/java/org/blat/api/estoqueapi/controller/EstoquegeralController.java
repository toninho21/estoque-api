package org.blat.api.estoqueapi.controller;

import org.blat.api.estoqueapi.model.Estoquegeral;
import org.blat.api.estoqueapi.service.EstoquegeralService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.List;



@RestController
@RequestMapping("/")
public class EstoquegeralController {
	
	@Autowired
	private EstoquegeralService estoquegeralService;
	
	@GetMapping(value = "/")
	public String hello() {
        //TODO
        return "Alo, minha API está OK";
    }

	@GetMapping(value = "/estoque")
	public List<Estoquegeral> get() {
        //TODO
        return estoquegeralService.findAll();
    }

}



