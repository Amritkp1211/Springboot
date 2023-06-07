package com.swagger.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.swagger.entities.Employee;

@Repository
public class EmployeeDao {

	@Autowired
   private JdbcTemplate jdbcTemplate;
    
	public void insertEmployee(Employee employee) {
		jdbcTemplate.update("insert into employee(eid,ename,salary) values(?,?,?)",
				     employee.getEid(),employee.getEname(),employee.getSalary());
	}
	
	public List<Employee> getAllEmp(){
		   List<Employee> list = jdbcTemplate.query("select * from employee", 
				   new BeanPropertyRowMapper<Employee>(Employee.class));
		return list;
	}
	
	public Employee getEmpbyId(int id) {
		 Employee employee = null;
		 try {
			employee= jdbcTemplate.queryForObject("select * from employee where eid=?",
					  new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));	
		} catch (Exception e) {
               e.printStackTrace();
		}	 
		return employee;
	}
	
	public int updateEmp(Employee employee) {
	      return this.jdbcTemplate.update("update employee set ename=?,salary=? where eid=?",
	    		   employee.getEname(),employee.getSalary(),employee.getEid());	
	}
	
	public boolean deleteEmployee(int id) {
        int i = jdbcTemplate.update("delete from emp loyee where eid=?",id);
	  if(i!=0) {
		  return true;
	  }
	  else {
		  return false;
	  }  
	}
}
