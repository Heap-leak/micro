package com.hipp.gatewayservice.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hipp.gatewayservice.service.UserService;

import reactor.core.publisher.Mono;

@RestController
public class GreetingController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public Mono<String> index(Mono<Principal> principal){
		return principal.map(Principal::getName)
				.flatMap(name -> userService.findUserByUsername(name))
				.map(user -> String.format("Hello, %s %s", user.getFirstName(), user.getLastName()));
	}
	
}
