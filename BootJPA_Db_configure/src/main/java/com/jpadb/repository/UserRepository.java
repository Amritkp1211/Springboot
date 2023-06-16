package com.jpadb.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpadb.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
  
	public List<User> findByName(String name);
	
	public List<User> findBynameOrCity(String name,String city);
	
	public List<User> findBynameStartingWith(String prefix);
	
	public List<User> findByIdLessThan(int id);
	
	public List<User> findByIdIn(Collection<Integer> id);
	
	@Query("select u From User u")
	public List<User> getAllUser();
	
	@Query("select u From User u WHERE u.name =:n")
	public List<User> getUserByName(@Param("n") String name);
}
