package com.basededatos.entregafinalbd2.service;

import java.util.List;

import com.basededatos.entregafinalbd2.domain.Role;
import com.basededatos.entregafinalbd2.domain.User;
import com.basededatos.entregafinalbd2.dto.UserDTO;
import com.google.common.base.Optional;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 */
public interface UserService {

	Iterable<User> findAll();

	User persist(User user);

	User get(long id);

	void delete(long id);

	Optional<User> getUserByUserName(String userName);

	boolean notAllowed(String username);

	List<User> findActiveUsers();

	User persist(UserDTO userDTO, boolean encode);

	List<Role> getAllRoles();

}
