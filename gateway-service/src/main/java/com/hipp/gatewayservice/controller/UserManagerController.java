package com.hipp.gatewayservice.controller;

import javax.ws.rs.PathParam;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hipp.gatewayservice.domain.Roles;
import com.hipp.gatewayservice.domain.User;
import com.hipp.gatewayservice.service.UserService;

import reactor.core.publisher.Mono;

@RestController
public class UserManagerController {
	
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	
	public UserManagerController(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/api/v1/add-user")
	public Mono<User> addUser() {
		User user = new User();
		user.setUsername("eku");
		user.setFirstName("Evgenii");
		user.setLastName("Kulemin");
		user.setPassword(passwordEncoder.encode("1234"));
		user.setEmail("xxxxx@qwerty.com");
		user.setUserRole(Roles.USER.name());
		user.setEnabled(true);
		
		return userService.findUserByUsername(user.getUsername()).switchIfEmpty(userService.save(user));
	}
	
	@GetMapping("/api/v1/delete-user")
	public Mono<Void> deleteUser(@PathParam(value = "username") String username) {
		return userService.findUserByUsername(username)
			.flatMap(userService::delete);
	}
}
