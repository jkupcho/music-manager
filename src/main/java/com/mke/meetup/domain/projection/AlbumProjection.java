package com.mke.meetup.domain.projection;

import org.springframework.data.rest.core.config.Projection;

import com.mke.meetup.domain.Album;
import com.mke.meetup.domain.Artist;

@Projection(types=Album.class, name="searchProjection")
public interface AlbumProjection {
	
	Artist getArtist();

}
