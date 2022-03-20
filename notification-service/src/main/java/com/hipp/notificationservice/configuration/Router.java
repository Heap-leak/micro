package com.hipp.notificationservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.hipp.notificationservice.controller.NotificationHandler;

@Configuration
public class Router {
	
//	private final RequestPredicate push = RequestPredicates.POST("/push").and(RequestPredicates.accept(MediaType.APPLICATION_JSON));
	private final RequestPredicate registration = RequestPredicates.POST("/notification/registration").and(RequestPredicates.accept(MediaType.APPLICATION_JSON));
	private final RequestPredicate deregistration = RequestPredicates.DELETE("/notification/deregistration").and(RequestPredicates.accept(MediaType.APPLICATION_JSON));
//	
	@Bean
	public RouterFunction<ServerResponse> route(NotificationHandler notificationHandler) {
		return RouterFunctions.route(registration, notificationHandler::registration)
				.andRoute(deregistration, notificationHandler::deregistration);
//		return RouterFunctions.route(push, notificationHandler::push)
//				.andRoute(registration, notificationHandler::registration)
//				
	}
}
