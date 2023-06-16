package com.exception.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.Dao.ResponseDao;
import com.exception.entity.Response;
import com.exception.entity.User;

@RestController
public class ResponseController {

	@GetMapping("/users")
	public Response<List<User>> getAllUser(){
		return Response.getdata(200,ResponseDao.user,"useres fetch successfully");
	}
}
