package com.basededatos.entregafinalbd2.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.basededatos.entregafinalbd2.domain.Perfume;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 *
 */
public class PerfumeDTO {

	private Long id;

	@Size(min = 8, max = 8, message = "El codigo debe contener 8 caracteres alfanumericos")
	private String codeName = "";
	@Size(min = 4, max = 20, message = "El nombre debe contener entre 4 y 20 caracteres")
	private String name = "";
	@Size(min = 2, max = 20, message = "La presentacion debe contener entre 2 y 20 caracteres")
	private String presentation = "";

	@Size(min = 2, max = 20, message = "La fragancia debe contener entre 2 y 20 caracteres")
	private String fragance = "";

	@NotNull
	private Integer stock = 0;

	public PerfumeDTO() {
		super();
	}

	public PerfumeDTO(long id, String codeName, String name, String presentation, String fragance, Integer stock) {
		super();
		this.id = id;
		this.codeName = codeName;
		this.name = name;
		this.presentation = presentation;
		this.fragance = fragance;

		this.stock = stock;
	}

	public PerfumeDTO(Perfume perfume) {
		this.id = perfume.getId();
		this.codeName = perfume.getCodeName();
		this.name = perfume.getName();
		this.fragance = perfume.getFragance();
		this.presentation = perfume.getPresentation();
		this.stock = perfume.getStock();

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
