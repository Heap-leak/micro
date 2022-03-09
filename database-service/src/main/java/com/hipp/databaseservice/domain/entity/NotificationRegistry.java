package com.hipp.databaseservice.domain.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "notificationregistry")
public class NotificationRegistry implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long notificationId;
	private String notificationUrl;
	private String username;
	
	

	@Column(value = "notificationid")
	public Long getNotificationId() {
		return notificationId;
	}
	
	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	@Column(value = "notificationurl")
	public String getNotificationUrl() {
		return notificationUrl;
	}
	
	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}
	
	@Column(value = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
