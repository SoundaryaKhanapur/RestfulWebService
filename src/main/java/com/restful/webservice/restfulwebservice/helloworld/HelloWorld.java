package com.restful.webservice.restfulwebservice.helloworld;

public class HelloWorld {

	private String message;

	public HelloWorld(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//automatic conversion won't work without a getter
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "HelloWorld [message=" + message + "]";
	}



	

}
