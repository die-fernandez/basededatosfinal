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
public class Clothes{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String codeName;
	private Integer stock;
	private String size;
	private String color;
	private ClothesType type;
	private String fabric;

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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ClothesType getType() {
		return type;
	}

	public void setType(ClothesType type) {
		this.type = type;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

}
