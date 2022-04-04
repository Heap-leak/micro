package com.hipp.gatewayservice.domain;

import java.util.Collection;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@Table(value = "users")
public class User implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String username;
	private String password;
	@Column(value = "user_role")
	private String userRole;
	@Transient
	private String password2;
	@Column(value = "first_name")
	private String firstName;
	@Column(value = "last_name")
	private String lastName;
	@Column(value = "email")
	private String email;	
	@Column(value = "account_expired")
	private boolean accountExpired;
	@Column(value = "account_locked")
	private boolean accountLocked;
	@Column(value = "credentials_expired")
	private boolean credentialsExpired;
	@Column(value = "account_enabled")
	private boolean enabled;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Set.of(userRole).stream().map(SimpleGrantedAuthority::new).toList();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return !accountExpired;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return !accountLocked;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return !credentialsExpired;
	}
	
}
