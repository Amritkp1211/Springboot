package com.customException.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customException.Service.UserService;
import com.customException.entiy.User;
import com.customException.exceptions.UserAlreadyExistException;
import com.customException.exceptions.UserNotFoundException;

@RestController
@RequestMapping("user")
public class UserController {
    
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> SaveUser(@RequestBody User user) throws UserAlreadyExistException{
		 User u1 = userService.saveUser(user);
		return new ResponseEntity<User>(u1, HttpStatus.CREATED);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) throws UserNotFoundException{
		return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") int id,@RequestBody User user){		
		return new ResponseEntity<User>(userService.updateUser(user,id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		System.out.println("delete Successfully");
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
}
