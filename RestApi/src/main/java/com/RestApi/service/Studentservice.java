package com.RestApi.service;

import java.util.List;

import com.RestApi.entity.Student;

public interface Studentservice {

	
	 public Student insertStudent(Student student);
	 
	 public List<Student> getAllStudents();
	 
	 public Student getStudentbyId(int id);

     public Student updateStudent(int id, Student student);

     public void deleteStudent(int id);
}
