package com.swagger.entities;

public class Response<T> {
	
	T data;
	int status;
	String msg;
	
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Response [data=" + data + ", status=" + status + ", msg=" + msg + "]";
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(T data, int status, String msg) {
		super();
		this.data = data;
		this.status = status;
		this.msg = msg;
	}
	
	public static <T> Response<T> getData(T data,String msg, int status){
		Response<T> response=new Response<>();
		response.setData(data);
		response.setMsg(msg);
		response.setStatus(status);
		return response;
	}
	

}
