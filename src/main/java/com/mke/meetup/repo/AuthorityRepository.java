package com.mke.meetup.repo;

import org.springframework.data.repository.CrudRepository;

import com.mke.meetup.domain.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, String> {

}
