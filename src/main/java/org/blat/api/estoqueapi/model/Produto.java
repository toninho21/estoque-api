package org.blat.api.estoqueapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class Produto {

	@Id
	@GeneratedValue
	@NotEmpty
	private Long produtoid;
	  
	@Column(length = 45)
	@NotEmpty
	private String nomeprod;
	  
	@Column(length = 100)
	private String descricaoprod;

	@Column(length = 80)
	@NotEmpty
	private String fabricante;
 
}

