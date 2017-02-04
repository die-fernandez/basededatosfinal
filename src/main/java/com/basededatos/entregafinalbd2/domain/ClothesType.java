package com.basededatos.entregafinalbd2.domain;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 *
 */


public enum ClothesType {

	CAMISA("CAMISA"), PANTALON("PANTALON"),REMERA("REMERA"), MALLA("MALLA"), PULLOVER("PULLOVER"),
	SHORT("SHORT");

	private String message;

	ClothesType(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
