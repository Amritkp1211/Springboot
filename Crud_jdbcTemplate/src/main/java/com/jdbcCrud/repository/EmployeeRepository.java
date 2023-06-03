package com.jdbcCrud.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jdbcCrud.entity.Employee;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertEmp(Employee e) {
	jdbcTemplate.update("insert into emp(eid,name,salary) values(?,?,?)",e.getEid(),e.getName(),e.getSalary());
	}
	
	public List<Employee> getAllEmployee(){
		return jdbcTemplate.query("select * from emp", new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	public Employee getEmpbyEmployeeId(int id) {
	   Employee employee=null;
	   try {
		  employee=jdbcTemplate.queryForObject("select * from emp where eid=?",new Object[]{id},
				  new BeanPropertyRowMapper<Employee>(Employee.class));
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return employee;
	}
   
	public int updateEmp(Employee employee) {
		return jdbcTemplate.update("update emp set name=?,salary=? where eid=?",employee.getName(),
				employee.getSalary(),employee.getEid());
	}
	public boolean deleteemp(int id) {
		int i = jdbcTemplate.update("delete from emp where eid=?",id);
		if(i==0) {
			return false;
		}
		else {
			return true;
			}
		}
	
}
