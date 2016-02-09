package com.mke.meetup.repo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mke.meetup.MusicManagerApplication;
import com.mke.meetup.domain.SiteUser;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MusicManagerApplication.class)
public class SiteUserRepositoryTest {
	
	@Autowired
	private SiteUserRepository siteUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void findOne_PasswordShouldBeHashed() {
		SiteUser admin = siteUserRepository.findOne("admin");
		
		assertNotEquals("admin", admin.getPassword());
		assertTrue(passwordEncoder.matches("admin", admin.getPassword()));
	}

}
