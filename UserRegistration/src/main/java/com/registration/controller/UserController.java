package com.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.registration.entity.User;
import com.registration.service.UserServicrImpl;

@Controller
public class UserController {
	
	@Autowired
    UserServicrImpl userServicrImpl;
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/all_user")
	public ModelAndView allUsers() {
		   List<User> list = userServicrImpl.getAllUsers();
		return new ModelAndView("all_user","user", list);
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/save")
	public String insertUser(@ModelAttribute User user) {
		userServicrImpl.insertUser(user);
		return "redirect:/all_user";
	}
	@GetMapping("/edit/{id}")
	public String getUser(@PathVariable("id") int id, Model model) {
		  User user = userServicrImpl.getUser(id);
		  model.addAttribute("user", user);
		return "edit";		
	}
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		       userServicrImpl.deleteUser(id);
		       return "redirect:/all_user";
	}
	
}
