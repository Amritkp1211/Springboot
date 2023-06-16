package com.exception.entity;

public class Response<T> {

	int status;
	T data;
	String message;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static<T> Response<T> getdata(int status, T data, String message) {
		  Response<T> response=new Response<>();
		    response.setStatus(status);
		    response.setData(data);
		    response.setMessage(message);
		return response;
		
	}
	
}
