package com.hipp.notificationservice.domain;

import java.io.Serializable;

public class NotificationRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String notificationUrl;
	private Long notificationId;
	private String username;

	public NotificationRequest() {}
	
	public NotificationRequest(Long notificationId, String notificationUrl) {
		this.notificationId = notificationId;
		this.notificationUrl = notificationUrl;
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
