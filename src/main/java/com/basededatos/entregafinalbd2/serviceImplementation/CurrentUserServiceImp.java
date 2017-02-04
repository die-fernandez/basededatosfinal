package com.basededatos.entregafinalbd2.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.basededatos.entregafinalbd2.domain.CurrentUser;
import com.basededatos.entregafinalbd2.domain.User;
import com.basededatos.entregafinalbd2.service.UserService;
import com.google.common.base.Optional;

/**
 * @author agustina.zimbello
 * @author rocio.munoz
 *
 */

@Service
public class CurrentUserServiceImp implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public CurrentUser loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userService.getUserByUserName(userName);
		return new CurrentUser(user.get());
	}
	

}
