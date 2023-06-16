package com.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.entity.User;
import com.registration.repo.UserRepo;

@Service
public class UserServicrImpl implements UserService {
  
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User insertUser(User user) {
		User u = userRepo.save(user);
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> list = userRepo.findAll();
		return list;
	}

	@Override
	public User getUser(int id) {
		 User user = userRepo.findById(id).get();
		return user;
	}

	@Override
	public void deleteUser(int id) {
		userRepo.deleteById(id);	
	}
  
}
