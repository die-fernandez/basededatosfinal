package com.basededatos.entregafinalbd2.domain;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 *
 */


public enum Role {

	EMPLOYEE("EMPLOYEE"), ADMIN("ADMIN");

	private String message;

	Role(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
