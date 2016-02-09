package com.mke.meetup.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SiteUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String username;
	
	@JsonIgnore
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="user_authorities_xref",
		joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
		inverseJoinColumns={@JoinColumn(name="authority", referencedColumnName="authority")}
	)
	private Set<Authority> authorities = new HashSet<>();
	
	public UserDetails toUserDetails() {
		Set<GrantedAuthority> secAuthorities = authorities
			.stream()
			.map(Authority::toGrantedAuthority)
			.collect(Collectors.toSet());
		
		return new User(username, password, secAuthorities);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Authority> getAuthorities() {
		return authorities;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
}
