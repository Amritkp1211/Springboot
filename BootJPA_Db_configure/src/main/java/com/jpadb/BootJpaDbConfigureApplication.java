package com.jpadb;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpadb.entities.User;
import com.jpadb.repository.UserRepository;

@SpringBootApplication
public class BootJpaDbConfigureApplication {

	public static void main(String[] args) {
		ApplicationContext a = SpringApplication.run(BootJpaDbConfigureApplication.class, args);
	    UserRepository userRepository=a.getBean(UserRepository.class);
	    
	    User u=new User();
	      u.setId(1);
	      u.setName("Amrit");
	      u.setCity("Sirohi");
			
	      User u1=new User();
	      u1.setId(2);
	      u1.setName("nitin");
	      u1.setCity("rampura");
	       
	      User u2=new User();
	      u2.setId(3);
	      u2.setName("YB");
	      u2.setCity("Kiwarli");
	     
	      /*
			 * Save meth0od for single user
			 * User u1 = userRepository.save(u); System.out.println(u1);
			 */
	      
			/*
			 * Saving multiple record
			 * List<User> users = List.of(u,u1,u2);
			 *  Iterable<User> s =userRepository.saveAll(users); 
			 * s.forEach(b->{ System.out.println(b); });
			 */
	      
			/*
			 * update User
			 * Optional<User> optional = userRepository.findById(1);
			 *  User user =optional.get();
			 *   user.setName("Bhamsa");
			 * User u3 = userRepository.save(user);
			 *  System.out.println(u3);
			 */
	         
			/* fINDING aLL THE uSER
			 * Iterable<User> fd = userRepository.findAll();
			 *  fd.forEach(s->{
			 *       System.out.println();
			 *                   });
			 */	     
	      
	      //Deleting single User
//	          userRepository.deleteById(1);
//	          System.out.println("user deleted");
			/*
			 * Iterable<User> i = userRepository.findAll();
			 *  i.forEach(f->{
			 * System.out.println(f); });
			 * 
			 * userRepository.deleteAll(i); 
			 * System.out.println("deleted all the user");
			 */
			/*
			 * List<User> user = List.of(u,u1,u2);
			 *  Iterable<User> itr = userRepository.saveAll(user);
			 *   System.out.println("save successfully");
			 * itr.forEach(e->{ System.out.println(e); });
			 */
	      
			/*Find by name user defined method
			 * List<User> w = userRepository.findByName("Amrit");
			 * w.forEach(e->System.out.println(e));
			 */
	      
			/* FInd by Name Or city User defind method
			 * List<User> fd = userRepository.findBynameOrCity("nitin","sirohi");
			 * 
			 * fd.forEach(e->System.out.println(e));
			 */
			/*
			 * List<User> fda = userRepository.findBynameStartingWith("A");
			 * fda.forEach(e->System.out.println(e));
			 */
	         
			/*
			 * List<User> l = userRepository.findByIdLessThan(179);
			 * l.forEach(e->System.out.println(e));
			 * System.out.println("---------------------------");
			 */
				 
			/*
			 * List<User> allUser = userRepository.getAllUser();
			 *  allUser.forEach(e->{
			 * System.out.println(e); 
			 *   });
			 * 
			 */	 
	          
	         userRepository.getUserByName("Amrit").forEach(e->System.out.println(e)); 
	         System.out.println("--------");
	           
	}

}
