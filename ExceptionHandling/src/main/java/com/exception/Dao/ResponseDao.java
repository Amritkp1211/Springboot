package com.exception.Dao;

import java.util.ArrayList;

import com.exception.entity.User;

public class ResponseDao {

	public static ArrayList<User> user=new ArrayList<>();
	static {
		 User u1=new User("Anrit","amrutkp122","123");
		 User u2=new User("nitin","nitin122","253");
		user.add(u1);user.add(u2);
	}
}
