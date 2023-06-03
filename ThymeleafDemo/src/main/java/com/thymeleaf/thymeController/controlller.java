package com.thymeleaf.thymeController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class controlller {
    
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("name", "amrit sindrath ");
		model.addAttribute("address","sirohi");
		System.out.println("inside the handler");
		return "about";
		//about.html
	}
	
	@GetMapping("/iterate")
	public String iterateInHtml( Model m) {
		List<String> names = List.of("Amrit","Nitin","Dinesh","Akash","Nikhil","Jatin");
		m.addAttribute("names", names);
		return "iterate";
	}
	
	@GetMapping("/condition")
	public String condition(Model model){
		model.addAttribute("isActive",true);
		model.addAttribute("gender","M");
		List<Integer> mylist = List.of(1,4,6,8,3,5,7);
		return "condition";
	}
	
	@GetMapping("/service")
	public String service(Model model) {
		
		model.addAttribute("title","Rajasthan");
		
		String s1 = LocalDateTime.now().toString();
		
		model.addAttribute("subtitle",s1);
		return "service";
	}
	
	@GetMapping("/about1")
	public String newabout() {
		
		return "aboutnew";
	}
	@GetMapping("/contact")
	public String contact() {
		
		return "contact";
	}
}
