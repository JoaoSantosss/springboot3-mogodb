package com.joaosantos.projectmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaosantos.projectmongo.domain.User;
import com.joaosantos.projectmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	@Autowired
	UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findall() {
		
		return ResponseEntity.ok().body();
	}

}
