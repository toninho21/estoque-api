package org.blat.api.estoqueapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Compras {

	@Id
	@GeneratedValue
	@NotEmpty
	private Long comprasid;
	  
	@Column
	@NotEmpty
	private Date datacompra;
	
	@Column
	@NotEmpty
	private Long produtocod;
	  
	@Column
	@NotEmpty
	private BigDecimal qtdcompra;

	@Column
	@NotEmpty
	private Long fornecedorid;
	
	@Column
	@NotEmpty
	private BigDecimal precounit;

	@Column
	@NotEmpty
	private Long comprador;
	
}

