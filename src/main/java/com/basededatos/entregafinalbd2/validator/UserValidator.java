package com.basededatos.entregafinalbd2.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.basededatos.entregafinalbd2.dto.UserDTO;
import com.basededatos.entregafinalbd2.service.UserService;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 * 
 */
@Component
public class UserValidator implements Validator {

	private final UserService userService;

	@Autowired
	public UserValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return UserDTO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		UserDTO user = (UserDTO) arg0;
		validatePasswords(errors, user);
		validateUsername(errors, user);
		validateEmptyPassword(errors, user);
	}

	private void validatePasswords(Errors errors, UserDTO user) {
		if (!(user.getPasswordRepeated().isEmpty())) {
			if (!user.getPassword().equals(user.getPasswordRepeated())) {
				errors.rejectValue("password", "EmptyField", "Las claves no concuerdan");

			}
		}
	}

	private void validateEmptyPassword(Errors errors, UserDTO user) {
		if (user.getId() == null) {
			if (user.getPassword().isEmpty()) {
				errors.rejectValue("password", "EmptyField", "La clave debe contener entre 6 y 12 caracteres");
			}
		}
	}

	private void validateUsername(Errors errors, UserDTO user) {
		if (userService.getUserByUserName(user.getUsername()).isPresent()) {
			if (user.getId() == null)
				errors.rejectValue("username", "EmptyField", "El nombre de usuario ingresado ya existe");

		}
	}

}
