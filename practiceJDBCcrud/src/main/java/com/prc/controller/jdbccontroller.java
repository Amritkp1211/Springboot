package com.prc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prc.entity.Village;
import com.prc.service.jdbcService;

@RestController
public class jdbccontroller {
    
	
	@Autowired
	private jdbcService jdbcService;
   
	@PostMapping("/insert")
	public void insertVillage(@RequestBody Village village){
		jdbcService.insertvillage(village);
	}
	
	@GetMapping("/edit/{id}")
	public Village getvillabyid(@PathVariable("id") int id){
		return jdbcService.getVillagebyId(id);	
	}
	
	@GetMapping("/list")
	public List<Village> getallvillage(){
		return jdbcService.getListofVillage();
	}
	
	@PutMapping("/update")
	public void updateVillage(@RequestBody Village village) {
		jdbcService.update(village);
	}
	@DeleteMapping("/delete/{id}")
	public void deletevillage(@PathVariable("id")int id) {
		jdbcService.deleteVillage(id);
	}
}
