package com.hipp.databaseservice.domain.model;

import java.io.Serializable;

public class NotificationRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String notificationUrl;
	private Long notificationId;
	private String username;

	public NotificationRequest() {}
	
	public NotificationRequest(Long notificationId, String notificationUrl, String username) {
		this.notificationId = notificationId;
		this.notificationUrl = notificationUrl;
		this.username = username;
	}
	
	public String getNotificationUrl() {
		return notificationUrl;
	}

	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}

	public Long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
