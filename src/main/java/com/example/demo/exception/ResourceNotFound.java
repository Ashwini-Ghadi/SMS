package com.example.demo.exception;

public class ResourceNotFound extends RuntimeException{

	public ResourceNotFound() {
		super("Resource Not Found in Database..!");
	}
	public ResourceNotFound(String msg){
		super(msg);
	}
	
}
