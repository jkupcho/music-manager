package com.mke.meetup.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
public class Authority {
	
	/***
	 * Needed by Hibernate.
	 */
	public Authority() {} 

	public Authority(String authority) {
		this.authority = authority;
	}
	
	@Id
	private String authority;
	
	public String getAuthority() {
		return authority;
	}
	
	public GrantedAuthority toGrantedAuthority() {
		return new SimpleGrantedAuthority(authority); 
	}
	
}
