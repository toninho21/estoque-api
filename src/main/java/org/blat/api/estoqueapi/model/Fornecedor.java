package org.blat.api.estoqueapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class Fornecedor {
	
	@Id
	@GeneratedValue
	@NotEmpty
	private Long fornecedorid;
	
	
	@Column(length = 100)
	@NotEmpty
	private String nomefornec;
	
	@Column
	@NotEmpty
	private Long ratingfornec;

}
