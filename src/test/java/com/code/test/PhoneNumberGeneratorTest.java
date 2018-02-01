package com.code.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PhoneNumberGeneratorTest {

	PhoneNumberGenerator png = null;
	
	@Before
	public void setup(){
		png = new PhoneNumberGenerator();
	}

	@Test
	public void testLetterCombinations() {
		List<String> lst = png.letterCombinations("23");
		assertNotNull(lst);
		assertEquals(16, lst.size());
	}
	
	@Test
	public void testLetterCombiantionsValues(){
		List<String> expectedList = new ArrayList<>();
		
		expectedList.add("12");
		expectedList.add("1a");
		expectedList.add("1b");
		expectedList.add("1c");
		
		List<String> actualList = png.letterCombinations("12");
		
		assertEquals(expectedList, actualList);
		
	}
	
	@Test
	public void testLetterCombiantionsCount(){
		List<String> actualList = png.letterCombinations("1234567890");
		assertEquals(102400, actualList.size());
	}
	
	@After
	public void tearDown(){
		png = null;
	}


}
