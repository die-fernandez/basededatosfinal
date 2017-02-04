package com.basededatos.entregafinalbd2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 *
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -5298767902451520474L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String userName;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String surname;

	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(nullable = false)
	private Boolean isActive;

	public User() {
		super();
	}

	public User(Long id, String username, String name, String surname, String password, Role role, Boolean isActive) {
		super();
		this.id = id;
		this.userName = username.toLowerCase();
		this.name = name;
		this.surname = surname;
		this.password = new BCryptPasswordEncoder().encode(password);
		this.role = role;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username.toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password, Boolean encode) {
		if (encode) {
			if (!password.isEmpty()) {
				this.password = new BCryptPasswordEncoder().encode(password);
			}
		} else
			this.password = password;

	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void changePermission() {
		if (role.equals(Role.ADMIN)) {
			role = Role.EMPLOYEE;
		} else {
			role = Role.ADMIN;
		}
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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



	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", name=" + name + ", surname=" + surname + ", password="
				+ password + ", role=" + role + ", isActive=" + isActive + "]";
	}

	public List<Role> getAllRoles() {
		List<Role> roles = new ArrayList<Role>();
		roles.add(Role.ADMIN);
		roles.add(Role.EMPLOYEE);
		return roles;
	}
}
