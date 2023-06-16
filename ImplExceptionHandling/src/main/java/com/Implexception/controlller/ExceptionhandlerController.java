package com.Implexception.controlller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Implexception.Exception.ProductNotFoundException;

@RestControllerAdvice
public class ExceptionhandlerController {
  
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> productException(ProductNotFoundException pe){
		return new ResponseEntity<>("product not found",HttpStatus.NOT_FOUND);
		
	}
}
