package com.jdbcCrud.controller;

import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdbcCrud.entity.Employee;
import com.jdbcCrud.repository.EmployeeRepository;

@RestController
public class EmployeeController {
    @Autowired
	private EmployeeRepository employeeRepository;
	
    @PostMapping("/insert/{eid}/{name}/{salary}")
     public Employee insertEmp(@PathVariable("eid") int id,@PathVariable("name") String name,@PathVariable("salary") String salary ,Employee employee) {
			/*
			 * employee.setEid(1); employee.setName("amrit"); employee.setSalary("11001");
			 */
    	 employeeRepository.insertEmp(employee);
    	 System.out.println("Data inserted successfully");
     return employee;
    }
    
    @GetMapping("/emplist")
    public List<Employee> getallemp(){
    	return this.employeeRepository.getAllEmployee();
    }
    
    @GetMapping("/edit/{id}")
    public Employee editemp(@PathVariable("id") int id) {
    	
    	Employee empbyEmployeeId = this.employeeRepository.getEmpbyEmployeeId(id);
    	  if(empbyEmployeeId==null) {
    		  return empbyEmployeeId;	  
    	  }
    	  else {
		        return empbyEmployeeId;   	
             }
    	  }
    @PutMapping("/update/{eid}/{name}/{salary}")
    public Employee updatemp(@PathVariable("eid") int id,@PathVariable("name") String name,@PathVariable("salary") String salary,Employee employee) {
    	System.out.println(employee.getEid());
    	if(employeeRepository.updateEmp(employee)!=0) {
    		return employee;
    	}
    	else {
			return employee;
		}
    }
    @DeleteMapping("/delete/{id}")
	public  String deleteEmp(@PathVariable("id") int id) {
          boolean i = this.employeeRepository.deleteemp(id);
          
          if(i==true) {
        	  return "delete successfully";
          }
          else {
        	  return "delete successfully";
          }
	}
    
    
}
