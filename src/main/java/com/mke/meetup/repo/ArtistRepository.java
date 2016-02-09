package com.mke.meetup.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import com.mke.meetup.domain.Artist;

public interface ArtistRepository extends PagingAndSortingRepository<Artist, Long> {

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	<S extends Artist> S save(S entity);
	
}
