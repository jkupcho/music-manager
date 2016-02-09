package com.mke.meetup.repo;

import org.springframework.data.repository.CrudRepository;

import com.mke.meetup.domain.MusicManagerUser;

public interface MusicManagerUserRepository extends CrudRepository<MusicManagerUser, String> {
	
}
