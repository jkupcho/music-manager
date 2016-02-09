package com.mke.meetup.repo;

import org.springframework.data.repository.CrudRepository;

import com.mke.meetup.domain.SiteUser;

public interface SiteUserRepository extends CrudRepository<SiteUser, String> {
	
}
