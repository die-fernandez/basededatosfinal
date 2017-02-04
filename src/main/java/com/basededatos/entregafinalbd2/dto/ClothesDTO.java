package com.basededatos.entregafinalbd2.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.basededatos.entregafinalbd2.domain.Clothes;
import com.basededatos.entregafinalbd2.domain.ClothesType;
import com.basededatos.entregafinalbd2.domain.Role;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 */
public class ClothesDTO {
	private Long id;

	@Size(min = 8, max = 8, message = "El codigo debe contener 8 caracteres alfanumericos")
	private String codeName = "";
	
	@Size(min = 4, max = 20, message = "El color debe contener entre 4 y 20 caracteres")
	private String color = "";
	
	@Size(min = 4, max = 20, message = "La tela debe contener entre 4 y 20 caracteres")
	private String fabric = "";
	
//	@Size(min = 4, max = 20, message = "El tipo debe contener entre 4 y 20 caracteres")
	@NotNull
	private ClothesType type = ClothesType.CAMISA;

	
	@Size(min = 1, max = 3)
	private String size = "";

	@NotNull
	private Integer stock = 0;

	public ClothesDTO() {
		super();
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public ClothesDTO(Long id ,String codeName, String color, String fabric, String size, ClothesType type, Integer stock) {
		super();
		this.id=id;
		this.codeName = codeName;
		this.color = color;
		this.fabric = fabric;
		this.size = size;
		this.type = type;
		this.stock = stock;
	}
	
	public ClothesType getType() {
		return type;
	}

	public void setType(ClothesType type) {
		this.type = type;
	}

	public ClothesDTO(Clothes clothes) {
		this.id = clothes.getId();
		this.codeName = clothes.getCodeName();
		this.color = clothes.getColor();
		this.fabric = clothes.getFabric();
		this.size = clothes.getSize();
		this.type= clothes.getType();
		this.stock=	clothes.getStock();
	}
	
	
	@Override
	public String toString() {
		return "ClothesDTO [id=" + id + ", code_name=" + codeName + ", color=" + color + ", fabric=" + fabric
				+ ", size=" + size + ", type=" + type + ", stock=" + stock + "]";
	}

	
	

}
