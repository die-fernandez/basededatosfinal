package com.basededatos.entregafinalbd2.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.basededatos.entregafinalbd2.domain.User;
import com.google.common.base.Optional;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 * 
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User findById(Long id);

	Optional<User> findByUserName(String userName);

}
