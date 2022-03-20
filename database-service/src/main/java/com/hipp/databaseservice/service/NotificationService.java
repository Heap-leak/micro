package com.hipp.databaseservice.service;

import org.springframework.stereotype.Service;

import com.hipp.databaseservice.domain.entity.NotificationRegistry;
import com.hipp.databaseservice.repository.NotificationRegistryRepository;

import reactor.core.publisher.Mono;

@Service
public class NotificationService {
		
	private final NotificationRegistryRepository notificationRegistryRepository;
	
	public NotificationService(NotificationRegistryRepository notificationRegistryRepository) {
		this.notificationRegistryRepository = notificationRegistryRepository;
	}

	public Mono<NotificationRegistry> registration(String url, String userName) {
		NotificationRegistry notificationRegistry = new NotificationRegistry();
		notificationRegistry.setNotificationUrl(url);
		notificationRegistry.setUsername(userName);
		
		return notificationRegistryRepository.save(notificationRegistry);
	}
	
	public Mono<Void> deregistration(Long notificationId) {
		System.out.println("NotificationId: " + notificationId);
		return notificationRegistryRepository.deleteById(notificationId);
	}
	
	public Mono<NotificationRegistry> fetchNotificationRegistry(Long id) {
		return notificationRegistryRepository.findById(id);
	}

}