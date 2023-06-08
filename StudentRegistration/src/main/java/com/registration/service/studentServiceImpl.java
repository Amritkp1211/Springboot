package com.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.entity.Student;
import com.registration.repo.StudentRepo;

@Service
public class studentServiceImpl implements Studentservice {
   
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public void insertStudent(Student student) {
		 studentRepo.save(student);	
	}
	public List<Student> allStudents() {
		List<Student> list = studentRepo.findAll();
		return list;
	}
	@Override
	public Student editStudent(int id) {
		return studentRepo.findById(id).get();
	}
	@Override
	public void deleteStudent(int id) {
		studentRepo.deleteById(id);	
	}
}
