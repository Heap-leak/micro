package com.hipp.gatewayservice.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.hipp.gatewayservice.domain.User;

import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends R2dbcRepository<User, Long> {
	@Query("select * from users where username = :username")
	public Mono<User> findByUsername(String username); 
}
