package com.code.test;


import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("phone")
public class NumberGeneratorController {
	
	@RequestMapping(value="numbers", method=RequestMethod.GET)
	public List<String> generateAlphanumericNumbers(
			@RequestParam("phone") String phone){
		if(phone == null ){
			throw new InvalidPhoneNumberException("Phone number is null");
		}else if(!phone.matches("[-+]?\\d*\\.?\\d+")){
			throw new InvalidPhoneNumberException("Phone number should be numeric");
		}
		PhoneNumberGenerator png = new PhoneNumberGenerator();
		return  png.letterCombinations(phone);
		
	}
}
