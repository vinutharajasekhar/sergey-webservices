package com.sergey.webservices.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sergey.webservices.request.UserRequest;
import com.sergey.webservices.response.UserResponse;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping(path ="/{userId}",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserResponse> getUser(@PathVariable String userId) {
		//return "get users was called with user id => "+userId;
		UserResponse userResponse = new UserResponse();
		userResponse.setFirstName("Rajasekhar Reddy");
		userResponse.setLastName("Kolli Venkata");
		userResponse.setUserName("reddyrajasekhar32@gmail.com");
		
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}
	
	
	@GetMapping()
	public String getUser(@RequestParam(value = "page", required = true, defaultValue = "2") int page, 
							@RequestParam(value = "limit", required=false, defaultValue = "40") int limit) {
		return "get users was called with page = "+page + " and limit = "+limit;
	}
	
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
							MediaType.APPLICATION_XML_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE,
							MediaType.APPLICATION_XML_VALUE}
				)
	public ResponseEntity<UserResponse> createUser(@Valid  @RequestBody UserRequest userRequest) {
		UserResponse userResponse = new UserResponse();
		userResponse.setFirstName(userRequest.getFirstName());
		userResponse.setLastName(userRequest.getLastName());
		userResponse.setUserName(userRequest.getEmail());
		return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
	}
	
	@PutMapping
	public String updateUser() {
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}

}
