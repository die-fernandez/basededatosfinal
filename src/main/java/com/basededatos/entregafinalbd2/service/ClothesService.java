package com.basededatos.entregafinalbd2.service;

import java.util.List;

import com.basededatos.entregafinalbd2.domain.Clothes;
import com.basededatos.entregafinalbd2.domain.ClothesType;
import com.basededatos.entregafinalbd2.domain.Role;
import com.basededatos.entregafinalbd2.dto.ClothesDTO;
import com.google.common.base.Optional;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 */
public interface ClothesService {

	Iterable<Clothes> findAll();

	Clothes persist(Clothes clothes);

	Clothes get(long id);

	void delete(long id);

	Optional<Clothes> getClothesByCodeName(String codeName);

	Clothes persist(ClothesDTO clothesDTO);

	List<ClothesType> getAllTypes();


}
