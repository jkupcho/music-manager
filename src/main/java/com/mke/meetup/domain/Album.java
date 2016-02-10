package com.mke.meetup.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Album {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="album")
	private Set<Song> songs = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="artist_id")
	private Artist artist;
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Song> getSongs() {
		return songs;
	}
	
	public Artist getArtist() {
		return artist;
	}
	
}
