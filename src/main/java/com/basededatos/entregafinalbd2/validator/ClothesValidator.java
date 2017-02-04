package com.basededatos.entregafinalbd2.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.basededatos.entregafinalbd2.dto.ClothesDTO;
import com.basededatos.entregafinalbd2.service.ClothesService;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 * 
 */
@Component
public class ClothesValidator implements Validator {

	private final ClothesService clothesService;

	@Autowired
	public ClothesValidator(ClothesService clothesService) {
		this.clothesService = clothesService;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return ClothesDTO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		ClothesDTO clothes = (ClothesDTO) arg0;
		validateStock(errors, clothes);
		validateCodeName(errors,clothes);
	}

	private void validateStock(Errors errors, ClothesDTO clothes) {
		if (clothes.getStock() == null) {
				errors.rejectValue("stock", "EmptyField", "Se debe ingresar un valor para el stock");
			}
		}
	
	private void validateCodeName(Errors errors, ClothesDTO clothes) {
		if (clothesService.getClothesByCodeName(clothes.getCodeName()).isPresent()) {
			if (clothes.getId() == null)
				errors.rejectValue("codeName", "EmptyField", "El codigo ingresado ya existe");

		}
	}
	}
