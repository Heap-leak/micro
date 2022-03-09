package com.hipp.databaseservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.hipp.databaseservice.handlers.NotificationHandler;

@Configuration
public class DatabaseRouter {
	private final RequestPredicate registration = RequestPredicates.POST("/registration").and(RequestPredicates.accept(MediaType.APPLICATION_JSON));
	private final RequestPredicate deregistration = RequestPredicates.DELETE("/deregistration").and(RequestPredicates.accept(MediaType.APPLICATION_JSON));
	
	@Bean
	public RouterFunction<ServerResponse> router(NotificationHandler notificationHandler) {
		return RouterFunctions.route(registration, notificationHandler::registration)
				.andRoute(deregistration, notificationHandler::deregistration);
	}
}
