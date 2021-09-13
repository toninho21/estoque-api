package org.blat.api.estoqueapi.model;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class Estoquegeral {

	@Id
	@GeneratedValue
	@NotEmpty
	private Long estoqueid;
	  
	@Column
	@NotEmpty
	private Long produto;
	  
	@Column(length = 45)
	private String nomeprod;

	@Column(length = 3)
	@NotEmpty
	private String unidade;
	
	@Column
	@NotEmpty
	private BigDecimal qtdatual;
 
	@Column
	@NotEmpty
	private BigDecimal qtdminima;
 
	@Column
	@NotEmpty
	private Long fornecedorid;
	  
	@Column(length = 45)
	private String nomefornec;
	
	@Column
	@NotEmpty
	private Date dataatualizacao;
}

