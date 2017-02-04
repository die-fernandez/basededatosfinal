package com.basededatos.entregafinalbd2.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.basededatos.entregafinalbd2.domain.CurrentUser;
import com.basededatos.entregafinalbd2.domain.User;
import com.basededatos.entregafinalbd2.dto.UserDTO;
import com.basededatos.entregafinalbd2.service.UserService;
import com.basededatos.entregafinalbd2.validator.UserValidator;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 *
 */
@Controller
public class UserController {

	private final UserService userService;
	private final UserValidator userCreateFormValidator;

	@Autowired
	public UserController(UserService userService, UserValidator userCreateFormValidator) {
		this.userService = userService;
		this.userCreateFormValidator = userCreateFormValidator;
	}

	@InitBinder("user")
	private void initBinder(WebDataBinder binder) {
		binder.addValidators(userCreateFormValidator);
	}

	@RequestMapping("/users")
	String list(Model model) {
		model.addAttribute("users", userService.findActiveUsers());
		return "user/list";
	}

	@RequestMapping("/users/delete/{id}")
	String delete(Model model, @PathVariable Long id) {
		userService.delete(id);
		return "redirect:/users";
	}

	@RequestMapping("/users/edit/{id}")
	String update(Model model, @PathVariable Long id) {
		model.addAttribute("user", new UserDTO(userService.get(id)));
		model.addAttribute("roles", userService.getAllRoles());
		return "user/form";
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("user") UserDTO user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("roles", userService.getAllRoles());
			return "user/form";
		} else {
			userService.persist(user, user.getPasswordRepeated().isEmpty());
			model.addAttribute("mensaje", "The registration process was succesful");
			return "redirect:/users";
		}
	}

	@RequestMapping("/users/changePermission/{id}")
	String changePermissions(Model model, @PathVariable Long id) {
		User user = userService.get(id);
		user.changePermission();
		userService.persist(user);
		return "redirect:/users";
	}

	@RequestMapping("/users/new")
	public String showNewUser(Model model) {
		UserDTO user = new UserDTO();
		model.addAttribute("user", user);
		model.addAttribute("roles", userService.getAllRoles());
		return "user/form";
	}
	
	@RequestMapping("profile")
	public String editProfile(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CurrentUser customUser = (CurrentUser) authentication.getPrincipal();
		Long id=customUser.getUser().getId();
		model.addAttribute("user", new UserDTO(userService.get(id)));
		return "user/editProfile";
	}
	
	@RequestMapping(value = "/profiles", method = RequestMethod.POST)
	public String profile(@Valid @ModelAttribute("user") UserDTO user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "user/editProfile";
		} else {
			userService.persist(user, true);
			model.addAttribute("mensaje", "The registration process was succesful");
			return "redirect:/";
		}
	}
}
