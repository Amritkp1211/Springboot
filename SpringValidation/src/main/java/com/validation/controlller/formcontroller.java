package com.validation.controlller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.thymeleaf.entities.LoginData;

import jakarta.validation.Valid;
@Controller
public class formcontroller {
  
	
	@GetMapping("/form")
	public String form(Model model) {
		
		model.addAttribute("login",new LoginData());
		return "form";
	}
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("login") LoginData login, BindingResult result) {
	   System.out.println(login);
		if(result.hasErrors()) {
	    	System.out.println(result);
	    	return "form";
	    }
		return "success";
	}
}
