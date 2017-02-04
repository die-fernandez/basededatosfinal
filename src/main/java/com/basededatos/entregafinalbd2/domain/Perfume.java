package com.basededatos.entregafinalbd2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 *
 */
@Entity
public class Perfume {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String codeName;
	private Integer stock;
	private String presentation;
	private String fragance;
	private String name; 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getFragance() {
		return fragance;
	}

	public void setFragance(String fragance) {
		this.fragance = fragance;
	}

}
