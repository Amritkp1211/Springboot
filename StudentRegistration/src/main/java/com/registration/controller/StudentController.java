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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.registration.entity.Student;
import com.registration.service.studentServiceImpl;

@Controller
public class StudentController {
 	
   @Autowired
   private studentServiceImpl studentServiceImpl;
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/register_student")
	public String registerStudent() {
		return "register_student";
	}
	
	@PostMapping("/save")
	public String insertStudent(@ModelAttribute Student student) {
		    studentServiceImpl.insertStudent(student);
		return "redirect:/all_student";
	}
	@GetMapping("/all_student")
	public ModelAndView allStudentlist() {
		List<Student> list = studentServiceImpl.allStudents();
		return new ModelAndView("all_student","students",list);
	}
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable("id") int id, Model model) {
		Student s1 = studentServiceImpl.editStudent(id);
		  model.addAttribute("s1", s1);
		  return "edit";
	}
	@RequestMapping("/delete/{id}")
	public String DeleteStudent(@PathVariable("id") int id){
		studentServiceImpl.deleteStudent(id);
		return "redirect:/all_student";
	}
	
}
