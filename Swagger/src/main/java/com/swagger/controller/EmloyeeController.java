package com.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.dao.EmployeeDao;
import com.swagger.entities.Employee;
import com.swagger.entities.Response;

@RestController
public class EmloyeeController {
   
	@Autowired
     private EmployeeDao employeeDao;
	
	@PostMapping("/emp")
	public Response<Employee> insertEmployee(@RequestBody Employee employee) {
		this.employeeDao.insertEmployee(employee);
		return Response.getData(employee,"employee inserted succeessfully",200);
	}
	@GetMapping("/emplist")
	public Response<List<Employee>> getAllEmp(){
		
		return Response.getData(employeeDao.getAllEmp(),"list fetch successfully",200);
	}
	
	@GetMapping("/emp/{id}")
	public Response<Employee> getemp(@PathVariable("id") int id){
		  Employee empbyId = this.employeeDao.getEmpbyId(id);
        if(empbyId==null) {
        	return Response.getData(empbyId,"invalid id", -1);
        }
        else {
        	return Response.getData(empbyId,"employee successfully retrieved",200);
		}
	}
	
	@PutMapping("/emp")
	public Response<Employee> updateEmp(@RequestBody Employee employee){
		  
		   if(this.employeeDao.updateEmp(employee)!=0) {
			   return Response.getData(employee,"updated successfully",200);
		   }
		   else {
			   return Response.getData(employee,"invalid employee id",-1);
		   }
	}
	@DeleteMapping("delete/{id}")
	public Response<Employee> deleteEMp(@PathVariable("id") int id){
		    if(employeeDao.deleteEmployee(id)==true) {
		    	  return Response.getData(null,"employee deleted successfully",200);
		    }
		    else {
		    	return Response.getData(null,"invalid id",-1);
		    }
	}
}
