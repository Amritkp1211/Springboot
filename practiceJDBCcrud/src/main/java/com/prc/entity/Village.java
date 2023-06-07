package com.prc.entity;


public class Village {
  
	private int vId;
	private String vName;
	private int vPincode;
	public int getvId() {
		return vId;
	}
	public void setvId(int vId) {
		this.vId = vId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public int getvPincode() {
		return vPincode;
	}
	public void setvPincode(int vPincode) {
		this.vPincode = vPincode;
	}
	public Village() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Village [vId=" + vId + ", vName=" + vName + ", vPincode=" + vPincode + "]";
	}
	public Village(int vId, String vName, int vPincode) {
		super();
		this.vId = vId;
		this.vName = vName;
		this.vPincode = vPincode;
	}
	
	
	
}
