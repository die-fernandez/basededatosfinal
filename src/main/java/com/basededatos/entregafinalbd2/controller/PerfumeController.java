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

import com.basededatos.entregafinalbd2.dto.PerfumeDTO;
import com.basededatos.entregafinalbd2.service.PerfumeService;
import com.basededatos.entregafinalbd2.validator.PerfumeValidator;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 *
 */
@Controller
public class PerfumeController {

	private final PerfumeService perfumeService;
	private final PerfumeValidator perfumeCreateFormValidator;

	@Autowired
	public PerfumeController(PerfumeService perfumeService, PerfumeValidator perfumeCreateFormValidator) {
		this.perfumeService = perfumeService;
		this.perfumeCreateFormValidator = perfumeCreateFormValidator;
	}

	@InitBinder("perfume")
	private void initBinder(WebDataBinder binder) {
		binder.addValidators(perfumeCreateFormValidator);
	}

	@RequestMapping("/perfumes")
	String list(Model model) {
		model.addAttribute("perfumes", perfumeService.findAll());
		return "perfume/list";
	}

	@RequestMapping("/perfumes/delete/{id}")
	String delete(Model model, @PathVariable Long id) {
		perfumeService.delete(id);
		return "redirect:/perfumes";
	}

	@RequestMapping("/perfumes/edit/{id}")
	String update(Model model, @PathVariable Long id) {
		model.addAttribute("perfume", new PerfumeDTO(perfumeService.get(id)));
		return "perfume/form";
	}

	@RequestMapping(value = "/perfumes", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("perfume") PerfumeDTO perfume, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("perfume", perfume);
			return "perfume/form";
		} else {
			perfumeService.persist(perfume);
			model.addAttribute("mensaje", "El articulo fue agregado exitosamente");
			return "redirect:/perfumes";
		}
	}

	@RequestMapping("/perfumes/new")
	public String showNewUser(Model model) {
		PerfumeDTO perfume = new PerfumeDTO();
		model.addAttribute("perfume", perfume);
		return "perfume/form";
	}
}
