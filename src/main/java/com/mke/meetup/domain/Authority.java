package com.mke.meetup.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
public class Authority {

	public Authority(final String authority) {
		this.authority = authority;
	}
	
	@Id
	private final String authority;
	
	public GrantedAuthority toGrantedAuthority() {
		return new SimpleGrantedAuthority(authority); 
	}
	
}
