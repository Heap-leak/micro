package com.hipp.gatewayservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.hipp.gatewayservice.service.UserService;

@EnableWebFluxSecurity
public class SecurityConfiguration {
	
	@Autowired	
	private UserService userService;

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		return http.authorizeExchange()
				.anyExchange()
				.authenticated()
				.and()
				.authenticationManager(authenticationManager())
				.formLogin()
				.and()
				.build();
	}
	
	private ReactiveAuthenticationManager authenticationManager() {
		var authManager = new UserDetailsRepositoryReactiveAuthenticationManager(userService);
		authManager.setPasswordEncoder(passwordEncoder());
		return authManager;
	}
			
	@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
	
}
