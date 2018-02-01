package com.code.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PhoneValidationApplicationTests {
	
	NumberGeneratorController controller = null;
	
	@Before
	public void setup(){
		controller =  new NumberGeneratorController();
	}

	@Test
	public void test_GenerateAlphanumericNumbers_Null_Input(){
		boolean thrown = false;
		try{
			List<String> lst = controller.generateAlphanumericNumbers(null);
		}
		catch(InvalidPhoneNumberException ie){
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void test_GenerateAlphanumericNumbers_Invalid_Input(){
		boolean thrown = false;
		try{
			List<String> lst = controller.generateAlphanumericNumbers("ABC");
		}
		catch(InvalidPhoneNumberException ie){
			thrown = true;
		}
		assertTrue(thrown);
		
	}
	
	@Test
	public void test_InvalidPhoneNumberException() {
	    try{
			controller.generateAlphanumericNumbers("123");
		}
		catch(InvalidPhoneNumberException ie){
			String message = "Phone number should be 7 or 10 digit";
			assertEquals(message, ie.getMessage());
			
		}
	}
	
	@Test
	public void test_GenerateAlphanumericNumbers_Count(){
		List<String> actualList = controller.generateAlphanumericNumbers("1234567890");
		assertEquals(102400, actualList.size());
	}
	
	@After
	public void tearDown(){
		controller = null;
	}

}
