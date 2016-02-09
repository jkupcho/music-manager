package com.mke.meetup.repo.support;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mke.meetup.MusicManagerApplication;
import com.mke.meetup.domain.SiteUser;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MusicManagerApplication.class)
public class SiteUserEventHandlerTest {

	@Autowired
	public SiteUserEventHandler handler;
	
	@Test
	public void verifyHashingNeeded() {
		SiteUser user = new SiteUser();
		user.setPassword("user");
		
		handler.setDefaults(user);
		
		assertNotEquals("user", user.getPassword());
	}
	
}
