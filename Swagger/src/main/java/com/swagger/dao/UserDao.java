package com.swagger.dao;

import java.util.ArrayList;

import com.swagger.entities.User;

public class UserDao {

	
	 public static ArrayList<User> users=new ArrayList<>();
	   
	    static {
	    	 User u1 =new User(),u2=new User(),u3=new User(),
	    	u4=new User(),u5=new User(),u6=new User(),u7=new User();
	    	 
	    	 u1=new User( u1.getUid(),"Amrit","amritkp@gmail.com","123");
	    	 u2=new User(u2.getUid(),"nitin","nitin@gmail.com","1254");
	    	 u3=new User(u3.getUid(),"rahul","rahul@gmail.com","145343");
	    	 u4=new User(u4.getUid(),"Himanshu","himanshhu@gmail.com","41231243"); 
	    	 u5=new User(u5.getUid(),"praveen","praveen@gmail.com","sdjf231243"); 
	    	 u6=new User(u6.getUid(),"hitesh","hiteshgmail.com","9823");
	    	 u7=new User(u7.getUid(),"Yogesh","yogesh@gmail.com","S453");
	    	 
	               users.add(u1);users.add(u2); users.add(u3); 
	               users.add(u4);users.add(u6);users.add(u7);
	    }
	
}
