package com.basededatos.entregafinalbd2.service;

import com.basededatos.entregafinalbd2.domain.Perfume;
import com.basededatos.entregafinalbd2.dto.PerfumeDTO;
import com.google.common.base.Optional;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 */
public interface PerfumeService {

	Iterable<Perfume> findAll();

	Perfume persist(Perfume perfume);

	Perfume get(long id);

	void delete(long id);

	Optional<Perfume> getPerfumeByName(String name);
	
	Optional<Perfume> getPerfumeByCodeName(String codeName);

	Perfume persist(PerfumeDTO perfumeDTO);

}
