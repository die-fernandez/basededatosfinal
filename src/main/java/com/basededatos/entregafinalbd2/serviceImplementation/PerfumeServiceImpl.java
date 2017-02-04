package com.basededatos.entregafinalbd2.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basededatos.entregafinalbd2.domain.Perfume;
import com.basededatos.entregafinalbd2.dto.PerfumeDTO;
import com.basededatos.entregafinalbd2.repository.PerfumeRepository;
import com.basededatos.entregafinalbd2.service.PerfumeService;
import com.google.common.base.Optional;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 *
 */
@Service
public class PerfumeServiceImpl implements PerfumeService {

	@Autowired
	private PerfumeRepository perfumeRepository;

	public PerfumeServiceImpl() {
		super();
	}

	@Override
	public Iterable<Perfume> findAll() {
		return (perfumeRepository.findAll());
	}

	@Override
	public Perfume persist(Perfume perfume) {
		return perfumeRepository.save(perfume);

	}

	@Override
	public Perfume persist(PerfumeDTO perfumeDTO) {
		Perfume perfume = new Perfume();
		perfume.setId(perfumeDTO.getId());
		perfume.setCodeName(perfumeDTO.getCodeName());
		perfume.setFragance(perfumeDTO.getFragance());
		perfume.setName(perfumeDTO.getName());
		perfume.setPresentation(perfumeDTO.getPresentation());
		perfume.setStock(perfumeDTO.getStock());
		return perfumeRepository.save(perfume);
	}

	@Override
	public Perfume get(long id) {
		return perfumeRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		perfumeRepository.delete(id);

	}

	@Override
	public Optional<Perfume> getPerfumeByName(String name) {
		return perfumeRepository.findByName(name);
	}
	
	@Override
	public Optional<Perfume> getPerfumeByCodeName(String codeName) {
		return perfumeRepository.findByCodeName(codeName);
	}

}
