package com.basededatos.entregafinalbd2.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basededatos.entregafinalbd2.domain.Clothes;
import com.basededatos.entregafinalbd2.domain.ClothesType;
import com.basededatos.entregafinalbd2.domain.Role;
import com.basededatos.entregafinalbd2.dto.ClothesDTO;
import com.basededatos.entregafinalbd2.repository.ClothesRepository;
import com.basededatos.entregafinalbd2.service.ClothesService;
import com.google.common.base.Optional;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 *
 */
@Service
public class ClothesServiceImp implements ClothesService {

	@Autowired
	private ClothesRepository clothesRepository;

	public ClothesServiceImp() {
		super();
	}

	@Override
	public Iterable<Clothes> findAll() {
		return (clothesRepository.findAll());
	}

	@Override
	public Clothes persist(Clothes clothes) {
		return clothesRepository.save(clothes);

	}

	@Override
	public Clothes persist(ClothesDTO clothesDTO) {
		Clothes clothes = new Clothes();
		clothes.setId(clothesDTO.getId());
		clothes.setCodeName(clothesDTO.getCodeName());
		clothes.setColor(clothesDTO.getColor());
		clothes.setFabric(clothesDTO.getFabric());
		clothes.setSize(clothesDTO.getSize());
		clothes.setType(clothesDTO.getType());
		clothes.setStock(clothesDTO.getStock());
		return clothesRepository.save(clothes);
	}

	@Override
	public Clothes get(long id) {
		return clothesRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		Clothes clothes = clothesRepository.findOne(id);
		clothesRepository.delete(clothes);

	}

	@Override
	public Optional<Clothes> getClothesByCodeName(String codeName) {
		return clothesRepository.findByCodeName(codeName);
	}

	@Override
	public List<ClothesType> getAllTypes() {
		List<ClothesType> types = new ArrayList<ClothesType>();
		for (ClothesType clothesType : ClothesType.values()) {
			types.add(clothesType);

		}
		return types;

	}

}
