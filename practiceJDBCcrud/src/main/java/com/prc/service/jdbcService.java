package com.prc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer.FromDecimalArguments;
import com.prc.entity.Village;

@Service
public class jdbcService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertvillage(Village village) {
			 this.jdbcTemplate.update("insert into village(vName,vPincode) values(?,?)",
				village.getvName(),village.getvPincode());	
	}
	 public Village getVillagebyId(int id) {
		 return jdbcTemplate.queryForObject("select * from village where vId=?",new Object[]{id},
				                            new BeanPropertyRowMapper<Village>(Village.class));
	 }
	 
	 public List<Village> getListofVillage(){
		 return jdbcTemplate.query("select * from village",
				                  new BeanPropertyRowMapper<Village>(Village.class));
	 }
	 public void update(Village village) {
		 jdbcTemplate.update("update village set vName=?,vPincode=? where vId=?",
				                village.getvName(),village.getvPincode(),village.getvId());
	 }
	 public boolean deleteVillage(int id) {
		 int update = jdbcTemplate.update("delete from village where vId=?",id);
	    
		 if(update!=0) {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
}
