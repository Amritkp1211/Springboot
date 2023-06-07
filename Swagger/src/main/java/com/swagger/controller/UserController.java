package com.swagger.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.dao.UserDao;
import com.swagger.entities.User;

@RestController
public class UserController {
	
	
	@GetMapping("/users")
	public ArrayList<User> getallUsers(){
		return UserDao.users;
	}
	
	@PostMapping("/user")
	public User insertUser(User user){
		UserDao.users.add(user);
		return user;	}
	
	@GetMapping("/user/{id}")
	public User getUserbyId(@PathVariable("id") int id) {
		for(int i=0;i<UserDao.users.size();i++) {
			if(UserDao.users.get(i).getUid()==id) {
				return UserDao.users.get(i);
			}
		}
		return null;
	}
	
	@PutMapping("/user")
    public User updateUser(@RequestBody User u) {
         for(int i=0;i<UserDao.users.size();i++) {
			 if(UserDao.users.get(i).getUid() == u.getUid()) {
				UserDao.users.get(i).setUname(u.getUname());
				UserDao.users.get(i).setUemail(u.getUemail());
				UserDao.users.get(i).setUpassword(u.getUpassword());
			}
		}
         return u;
	}
	@DeleteMapping("/user/{id}")
	public User deleteUser(@PathVariable("id") int id) {
		User u1=null;
		for(User u: UserDao.users) {
			if(u.getUid()==id) {
				u1=u;
				break;
			}
		}
		UserDao.users.remove(u1);
		System.out.println("deleted successfully");
		return u1;
	}
}
