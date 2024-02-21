package com.restful.webservice.restweb.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


@RestController
public class UserResource {
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
	this.service=service;
	}
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return service.findAll();
		
	}
	
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id){
		User user=service.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id:"+id);
	return service.findOne(id);
	}
	
	@PostMapping("/users")
	public void createUser(@Valid @RequestBody User user) {
		service.save(user);
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
	 service.deleteById(id);
	}
}
