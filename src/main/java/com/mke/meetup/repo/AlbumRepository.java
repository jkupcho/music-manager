package com.mke.meetup.repo;

import org.springframework.data.repository.CrudRepository;

import com.mke.meetup.domain.Album;

public interface AlbumRepository extends CrudRepository<Album, Long> {

}
