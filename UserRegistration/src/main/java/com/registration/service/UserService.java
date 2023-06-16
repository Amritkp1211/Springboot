package com.registration.service;

import java.util.List;

import com.registration.entity.User;

public interface UserService 
{
   public User insertUser(User user);
   
   public List<User> getAllUsers();
   
   public User getUser(int id);
   
   public void deleteUser(int id);
}
