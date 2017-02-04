package com.basededatos.entregafinalbd2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.basededatos.entregafinalbd2.dto.ClothesDTO;
import com.basededatos.entregafinalbd2.service.ClothesService;
import com.basededatos.entregafinalbd2.validator.ClothesValidator;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 */
@Controller
public class ClothesController {
	private final ClothesService clothesService;
	private final ClothesValidator clothesCreateFormValidator;

	@Autowired
	public ClothesController(ClothesService clothesService,ClothesValidator clothesCreateFormValidator) {
		this.clothesService = clothesService;
		this.clothesCreateFormValidator=clothesCreateFormValidator;
	}

	
	@InitBinder("clothes")
	private void initBinder(WebDataBinder binder) {
		binder.addValidators(clothesCreateFormValidator);
	}
	
	@RequestMapping("/clothes")
	String list(Model model) {
		model.addAttribute("clothes", clothesService.findAll());
		return "clothes/list";
	}

	
	@RequestMapping("/clothes/delete/{id}")
	String delete(Model model, @PathVariable Long id) {
		clothesService.delete(id);
		return "redirect:/clothes";
	}

	@RequestMapping("/clothes/edit/{id}")
	String update(Model model, @PathVariable Long id) {
		model.addAttribute("clothes", new ClothesDTO(clothesService.get(id)));
		model.addAttribute("types", clothesService.getAllTypes());
		return "clothes/form";
	}


	
	@RequestMapping(value = "/clothes", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("clothes") ClothesDTO clothes, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("clothes", clothes);
			model.addAttribute("types", clothesService.getAllTypes());
			return "clothes/form";
		} else {
			clothesService.persist(clothes);
			model.addAttribute("mensaje", "The registration process was succesful");
			return "redirect:/clothes";
		}
	}


	@RequestMapping("/clothes/new")
	public String showNewClothes(Model model) {
		ClothesDTO clothes = new ClothesDTO();
		model.addAttribute("clothes", clothes);
		model.addAttribute("types", clothesService.getAllTypes());
		return "clothes/form";
	}
}
