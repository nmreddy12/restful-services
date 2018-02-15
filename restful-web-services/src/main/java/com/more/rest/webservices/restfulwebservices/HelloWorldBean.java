package com.more.rest.webservices.restfulwebservices;

public class HelloWorldBean {

	private String msg;

	public HelloWorldBean(String msg) {
		// TODO Auto-generated constructor stub
		this.setMsg(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + msg + "]";
	}
	
	

}
