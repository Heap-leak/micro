package com.hipp.databaseservice.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.hipp.databaseservice.domain.entity.NotificationRegistry;
import com.hipp.databaseservice.domain.model.NotificationRequest;
import com.hipp.databaseservice.service.NotificationService;

import reactor.core.publisher.Mono;

@Component
public class NotificationHandler {
	Logger logger = LoggerFactory.getLogger(NotificationHandler.class);
	
	private final NotificationService notificationService;
	
	public NotificationHandler(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public Mono<ServerResponse> registration(@RequestBody ServerRequest request) {
		return request.bodyToMono(NotificationRequest.class)
				.map(req -> notificationService.registration(req.getNotificationUrl(), req.getUsername()))
				.flatMap(notificationRegistry -> ServerResponse.ok().body(notificationRegistry, NotificationRegistry.class));
	}
	
	public Mono<ServerResponse> deregistration(@RequestBody ServerRequest request) {
		logger.info("Dereg");
		return request.bodyToMono(NotificationRequest.class)
				.map(req -> notificationService.deregistration(req.getNotificationId()))
				.flatMap(obj -> ServerResponse.ok().body(BodyInserters.fromValue("Deregistered")));
	}	
}
