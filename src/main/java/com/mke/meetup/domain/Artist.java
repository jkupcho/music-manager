package com.mke.meetup.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Artist {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@CreatedBy
	private String createdBy;
	
	@CreatedDate
	private LocalDateTime createdDate;
	
	@LastModifiedBy
	private String lastModifiedBy;
	
	@LastModifiedDate
	private LocalDateTime lastModifiedDate;
	
	@OneToMany(mappedBy="artist")
	private Set<Album> albums = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
}
