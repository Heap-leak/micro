package com.hipp.notificationservice.domain;

import java.io.Serializable;

public class NotificationRegistry implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Long notificationId; 
	private String notificationUrl;
	private String username;

	public Long getNotificationId() {
		return notificationId;
	}
	
	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	public String getNotificationUrl() {
		return notificationUrl;
	}
	
	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
