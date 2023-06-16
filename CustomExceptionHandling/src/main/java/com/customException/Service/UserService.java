package com.customException.Service;

import java.util.List;

import com.customException.entiy.User;
import com.customException.exceptions.UserAlreadyExistException;
import com.customException.exceptions.UserNotFoundException;


public interface UserService {
 
	//for creating user
	User saveUser(User user) throws  UserAlreadyExistException;
	
	//Get All the User list
	List<User> getAllUser() throws UserNotFoundException;
	
	//get Single User
	User getUser(int id) throws UserNotFoundException;
	
	//update User
	User updateUser(User user,int id) throws UserNotFoundException,UserAlreadyExistException;

	//delete User
	void deleteUser(int id) throws UserNotFoundException;
}
