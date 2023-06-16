package com.customException.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.customException.entiy.User;

@RestControllerAdvice
public class Globalexception {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity userNotFond(UserNotFoundException ue){
		return new ResponseEntity(ue.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<Object> userAlreadyExists(UserAlreadyExistException ua) {
		return new ResponseEntity(ua.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
