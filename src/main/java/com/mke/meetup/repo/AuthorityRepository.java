package com.mke.meetup.repo;

import org.springframework.data.repository.CrudRepository;

import com.mke.meetup.domain.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, String> {

	String USER = "ROLE_USER";
	String ADMIN = "ROLE_ADMIN";

}
