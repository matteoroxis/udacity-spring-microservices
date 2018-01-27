package com.matteoroxis.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matteoroxis.rest.webservices.restfulwebservices.DAO.UserServiceDAO;
import com.matteoroxis.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.matteoroxis.rest.webservices.restfulwebservices.model.User;

@RestController
public class UserController {

	@Autowired
	private UserServiceDAO userService;

	// GET /users
	// Retrieve all users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userService.findAll();
	}

	// GET /users/id
	// Retrieve a single user by id
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = userService.findOne(id);
		
		if(user == null){
			throw new UserNotFoundException("id - "+id);
		}
		
		return user;
	}

	// POST /users
	// input - details of user
	// output - CREATED & return the created URI
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = userService.save(user);
		// CREATED
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

}
