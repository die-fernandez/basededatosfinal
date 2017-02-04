package com.basededatos.entregafinalbd2.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.basededatos.entregafinalbd2.domain.Clothes;
import com.google.common.base.Optional;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 * 
 */
@RepositoryRestResource(collectionResourceRel = "clothes", path = "clothes")
public interface ClothesRepository extends PagingAndSortingRepository<Clothes, Long> {

	Clothes findById(Long id);

	Optional<Clothes> findByCodeName(String codeName);

}
