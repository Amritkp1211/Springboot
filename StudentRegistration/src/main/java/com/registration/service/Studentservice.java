package com.registration.service;

import java.util.List;

import com.registration.entity.Student;

public interface Studentservice {
  
	public void insertStudent(Student student);
	
	public List<Student> allStudents();
	
	public Student editStudent(int id);
	
	public void deleteStudent(int id);
}
