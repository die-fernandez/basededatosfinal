package com.basededatos.entregafinalbd2.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.basededatos.entregafinalbd2.domain.Role;
import com.basededatos.entregafinalbd2.domain.User;


/**
 * @author agustina.zimbello
 * @author rocio.munoz
 *
 */
public class UserDTO {
	
	private Long id;

	@Size(min = 4, max = 20, message = "El nombre de usuario debe contener entre 4 y 20 caracteres")
	private String username = "";
	
	@Size(min = 2, max = 20, message = "El nombre debe contener entre 2 y 20 caracteres")
	private String name = "";
	
	@Size(min = 2, max = 20, message = "El apellido debe contener entre 2 y 20 caracteres")
	private String surname = "";

	@Size(min = 6, max = 12)
	private String password = "";

	@Size(min = 6, max = 12)
	private String passwordRepeated = "";

	@NotNull
	private Role role = Role.EMPLOYEE;

	public UserDTO() {
		super();
	}

	public UserDTO(Long id ,String username, String name, String surname, String password, String passwordRepeated, Role role) {
		super();
		this.id=id;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.passwordRepeated = passwordRepeated;
		this.role = role;
	}
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.role = user.getRole();
		this.password= user.getPassword();
			}
	
	
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", name=" + name + ", surname=" + surname
				+ ", password=" + password + ", passwordRepeated=" + passwordRepeated + ", role=" + role + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

}
