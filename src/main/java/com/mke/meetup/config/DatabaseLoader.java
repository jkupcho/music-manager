package com.mke.meetup.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.mke.meetup.domain.Album;
import com.mke.meetup.domain.Authority;
import com.mke.meetup.domain.SiteUser;
import com.mke.meetup.domain.Song;
import com.mke.meetup.repo.AlbumRepository;
import com.mke.meetup.repo.AuthorityRepository;
import com.mke.meetup.repo.SiteUserRepository;
import com.mke.meetup.repo.SongRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final SiteUserRepository siteUserRepository;
	private final AuthorityRepository authorityRepository;
	private final AlbumRepository albumRepository;
	private final SongRepository songRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public DatabaseLoader(SiteUserRepository siteUserRepository, 
			AuthorityRepository authorityRepository, 
			AlbumRepository albumRepository,
			SongRepository songRepository,
			PasswordEncoder passwordEncoder) {
		this.siteUserRepository = siteUserRepository;
		this.authorityRepository = authorityRepository;
		this.passwordEncoder = passwordEncoder;
		this.albumRepository = albumRepository;
		this.songRepository = songRepository;
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		setupUsers();
	}

	private void setupUsers() {
		Authority userAuthority = createAuthority("ROLE_USER");
		Authority adminAuthority = createAuthority("ROLE_ADMIN");
		
		List<Authority> userRoles = Arrays.asList(userAuthority);
		List<Authority> adminRoles = Arrays.asList(userAuthority, adminAuthority);

		SiteUser user = createSiteUser("user", "user", userRoles);
		SiteUser admin = createSiteUser("admin", "admin", adminRoles);
		
		siteUserRepository.save(user);
		siteUserRepository.save(admin);
		
		Album album = new Album();
		album.setName("Some Album");
		
		albumRepository.save(album);
		
		Song firstSong = new Song();
		firstSong.setName("First Song");
		firstSong.setAlbum(album);
		
		Song secondSong = new Song();
		secondSong.setName("Second Song");
		secondSong.setAlbum(album);
		
		songRepository.save(Arrays.asList(firstSong, secondSong));
	}

	private SiteUser createSiteUser(String username, String password, List<Authority> roles) {
		SiteUser user = new SiteUser();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		user.getAuthorities().addAll(roles);
		return user;
	}

	private Authority createAuthority(String role) {
		Authority userAuthority = new Authority(role);
		authorityRepository.save(userAuthority);
		return userAuthority;
	}

}
