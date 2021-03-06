package com.mke.meetup.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.mke.meetup.domain.SiteUser;

public interface SiteUserRepository extends CrudRepository<SiteUser, Long> {
	
	SiteUser findOneByUsername(@Param("username") String username);
	
}
