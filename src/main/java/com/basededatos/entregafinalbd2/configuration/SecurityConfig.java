package com.basededatos.entregafinalbd2.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.basededatos.entregafinalbd2.domain.Role;
import com.basededatos.entregafinalbd2.domain.User;
import com.basededatos.entregafinalbd2.service.UserService;
import com.basededatos.entregafinalbd2.serviceImplementation.CurrentUserServiceImp;


@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CurrentUserServiceImp userDetailsService;

	@Autowired
	private UserService userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		userService.persist(new User(1L, "employee", "nombre", "apellido", "employee", Role.EMPLOYEE, true));
		userService.persist(new User(2L, "admin","nombreadmin","apellidoadmin", "admin", Role.ADMIN, true));
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/clothes/**").hasAnyAuthority("ADMIN","EMPLOYEE").antMatchers("/clothes").hasAnyAuthority("ADMIN","EMPLOYEE")
				.antMatchers("/users/**").hasAuthority("ADMIN").antMatchers("/user").hasAuthority("ADMIN")
				.antMatchers("/perfumes").hasAnyAuthority("ADMIN","EMPLOYEE").antMatchers("/perfumes/**").hasAnyAuthority("ADMIN","EMPLOYEE").and()
				.formLogin().loginPage("/login").permitAll().and().logout()
				// .logoutSuccessUrl("/")
				.permitAll().and().exceptionHandling().accessDeniedPage("/403");

	}

}