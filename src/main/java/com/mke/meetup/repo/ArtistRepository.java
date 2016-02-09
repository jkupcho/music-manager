package com.mke.meetup.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mke.meetup.domain.Artist;

public interface ArtistRepository extends PagingAndSortingRepository<Artist, Long> {

}
