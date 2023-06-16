package com.customException.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;


import com.customException.Repository.UserRepository;
import com.customException.Service.UserService;
import com.customException.entiy.User;
import com.customException.exceptions.UserAlreadyExistException;
import com.customException.exceptions.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) throws UserAlreadyExistException {
		 if(userRepository.existsById(user.getUid())) {
			 throw new UserAlreadyExistException("user is already exists");
		 }
		   User u= userRepository.save(user);
		return u;
	}

	@Override
	public List<User> getAllUser() throws UserNotFoundException {         
		return userRepository.findAll();
	}

	@Override
	public User getUser(int id) throws UserNotFoundException {
		User u1;
		 if(userRepository.findById(id).isEmpty()) {
			 throw new UserNotFoundException("user is not found try with another id");
		 }
		 else {
		 u1 = userRepository.findById(id).get();
		 }
		return u1;
	}

	@Override
	public User updateUser(User user, int id) throws UserNotFoundException, UserAlreadyExistException {
		  User u2 = userRepository.findById(id).get();
		    u2.setName(user.getName());
		    u2.setEmail(user.getEmail());
		    u2.setAddress(user.getAddress());
		 return userRepository.save(u2);	 
	}

	@Override
	public void deleteUser(int id) throws UserNotFoundException {
		 if(userRepository.findById(id).isEmpty()) {
			 throw new UserNotFoundException("user is not found try with another id");
		 }
		userRepository.deleteById(id);
	}

}
