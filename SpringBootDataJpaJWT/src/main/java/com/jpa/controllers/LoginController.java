package com.jpa.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.User;
import com.jpa.exceptions.LoginException;
import com.jpa.jwt.JwtUtil;
import com.jpa.jwt.LoginData;
import com.jpa.repository.UserRepository;

@RestController

@RequestMapping("/login")
public class LoginController {
	@Autowired
	UserRepository repository;

	@Autowired
	JwtUtil util;
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody LoginData data) {

		String userName = data.getUsername();
		String password = data.getPassword();
		
		Optional<User> opt = repository.findById(userName);
		
		if(!opt.isPresent())
			throw new LoginException("Invalid user name");
		
		User user = opt.get();
		
		if(!(user.getPassword().equals(password)))
			throw new LoginException("Invalid password");
		
		String token = util.generateToken(user);
		return new ResponseEntity<String>(token,HttpStatus.OK);

	}
}
