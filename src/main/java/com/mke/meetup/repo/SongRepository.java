package com.mke.meetup.repo;

import org.springframework.data.repository.CrudRepository;

import com.mke.meetup.domain.Song;

public interface SongRepository extends CrudRepository<Song, Long> {

}
