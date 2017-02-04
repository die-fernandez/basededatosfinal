package com.basededatos.entregafinalbd2.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.basededatos.entregafinalbd2.dto.PerfumeDTO;
import com.basededatos.entregafinalbd2.service.PerfumeService;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 * 
 */
@Component
public class PerfumeValidator implements Validator {

	private final PerfumeService perfumeService;

	@Autowired
	public PerfumeValidator(PerfumeService perfumeService) {
		this.perfumeService = perfumeService;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return PerfumeDTO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		PerfumeDTO perfume = (PerfumeDTO) arg0;
		validateStock(errors, perfume);
		validateCodeName(errors,perfume);
	}

	private void validateStock(Errors errors, PerfumeDTO perfume) {
		if (perfume.getStock() == null) {
		
				errors.rejectValue("stock", "EmptyField", "Se debe ingresar un valor para el stock");
			}
		}
	

private void validateCodeName(Errors errors, PerfumeDTO perfume) {
	if (perfumeService.getPerfumeByCodeName(perfume.getCodeName()).isPresent()) {
		if (perfume.getId() == null)
			errors.rejectValue("codeName", "EmptyField", "El codigo ingresado ya existe");

	}
}
}

