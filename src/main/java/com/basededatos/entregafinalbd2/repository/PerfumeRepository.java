package com.basededatos.entregafinalbd2.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.basededatos.entregafinalbd2.domain.Perfume;
import com.basededatos.entregafinalbd2.domain.User;
import com.google.common.base.Optional;


/**
 * @author agustina.zimbello
 * @author rocio.munoz
 * 
 */
@RepositoryRestResource(collectionResourceRel = "perfumes", path = "perfumes")
public interface PerfumeRepository extends PagingAndSortingRepository<Perfume, Long> {

	Perfume findById(Long id);

	Optional<Perfume> findByName(String name);

	Optional<Perfume> findByCodeName(String codeName);
}
