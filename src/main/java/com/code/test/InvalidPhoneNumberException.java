package com.code.test;


public class InvalidPhoneNumberException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidPhoneNumberException(){
		super();
	}
	
	public InvalidPhoneNumberException(String str){
		super(str);
	}
}
