package com.basededatos.entregafinalbd2.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basededatos.entregafinalbd2.domain.Role;
import com.basededatos.entregafinalbd2.domain.User;
import com.basededatos.entregafinalbd2.dto.UserDTO;
import com.basededatos.entregafinalbd2.repository.UserRepository;
import com.basededatos.entregafinalbd2.service.UserService;
import com.google.common.base.Optional;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 *
 */
@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	public UserServiceImp() {
		super();
	}

	@Override
	public Iterable<User> findAll() {
		return (userRepository.findAll());
	}

	@Override
	public List<User> findActiveUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		return users.stream().filter(user -> user.getIsActive()).collect(Collectors.toList());
	}

	@Override
	public User persist(User user) {
		return userRepository.save(user);

	}

	@Override
	public User persist(UserDTO userDTO, boolean encode) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setPassword(userDTO.getPassword(), encode);
		user.setUsername(userDTO.getUsername());
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setRole(userDTO.getRole());
		user.setIsActive(true);
		return userRepository.save(user);
	}

	@Override
	public User get(long id) {
		return userRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		User user = userRepository.findOne(id);
		user.setIsActive(false);
		userRepository.save(user);

	}

	@Override
	public Optional<User> getUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public List<Role> getAllRoles() {
		List<Role> roles = new ArrayList<Role>();
		roles.add(Role.ADMIN);
		roles.add(Role.EMPLOYEE);
		return roles;
	}

	@Override
	public boolean notAllowed(String userName) {
		if (this.getUserByUserName(userName) != null) {
			return true;
		} else {
			return false;
		}
	}

}
