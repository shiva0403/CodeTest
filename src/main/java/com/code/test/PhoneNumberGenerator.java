package com.code.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberGenerator {
	
	
	/**
	 * letterCombinations
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
	    Map<Character, char[]> map = createMap();
	 
	    List<String> result = new ArrayList<>();
	    if("".equals(digits))
	        return result;
	 
	    helper(result, new StringBuilder(), digits, 0, map);
	 
	    return result;
	 
	}

	/**
	 * createMap
	 * @return
	 */
	private Map<Character, char[]> createMap() {
		Map<Character, char[]> map = new HashMap<Character, char[]>();
	    map.put('0', new char[]{'0'});
	    map.put('1', new char[]{'1'});
	    map.put('2', new char[]{'2','a','b','c'});
	    map.put('3', new char[]{'3','d','e','f'});
	    map.put('4', new char[]{'4','g','h','i'});
	    map.put('5', new char[]{'5','j','k','l'});
	    map.put('6', new char[]{'6','m','n','o'});
	    map.put('7', new char[]{'7','p','q','r','s'});
	    map.put('8', new char[]{'8','t','u','v'});
	    map.put('9', new char[]{'9','w','x','y','z'});
		return map;
	}
	 
	private void helper(List<String> result, StringBuilder sb, String digits, int index, Map<Character, char[]> map){
	    if(index >= digits.length()){
	        result.add(sb.toString());
	        return;
	    }
	 
	    char c = digits.charAt(index);
	    char[] arr = map.get(c);
	 
	    for(int i=0; i<arr.length; i++){
	        sb.append(arr[i]);
	        helper(result, sb, digits, index+1, map);
	        sb.deleteCharAt(sb.length()-1);
	    }
	}
}
