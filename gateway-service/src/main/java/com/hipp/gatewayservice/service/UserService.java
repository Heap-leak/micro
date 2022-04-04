package com.hipp.gatewayservice.service;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.hipp.gatewayservice.domain.User;
import com.hipp.gatewayservice.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService implements ReactiveUserDetailsService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Mono<User> findById(Long id) {
		return userRepository.findById(id);
	}
	
	public Mono<User> save(User user) {
		return userRepository.save(user);
	}
	
	public Mono<Void> delete(User user) {
		return userRepository.delete(user);
	}
	
	public Flux<User> findAll(){
		return userRepository.findAll();
	}
	
	public Mono<User> findUserByUsername(String userName){
		return userRepository.findByUsername(userName);		
	}
	
	@Override
	public Mono<UserDetails> findByUsername(String username) {
		return userRepository.findByUsername(username).cast(UserDetails.class);
	}
}
