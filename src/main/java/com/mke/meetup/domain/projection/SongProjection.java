package com.mke.meetup.domain.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.mke.meetup.domain.Song;

@Projection(types=Song.class, name="lowerCase")
public interface SongProjection {

	@Value("#{target.name.toLowerCase()}")
	String getLowerCaseName();
	String getName();
	
}
