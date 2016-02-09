package com.mke.meetup.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/user")
	public ResponseEntity<UserDetails> userDetails(Authentication authentication) {
		return new ResponseEntity<>((UserDetails)authentication.getPrincipal(), HttpStatus.OK);
	}
	
}
