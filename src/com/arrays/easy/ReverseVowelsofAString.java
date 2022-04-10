package com.arrays.easy;

import java.util.ArrayList;

public class ReverseVowelsofAString {

	
	public static String reverseVowelsOfString(StringBuilder s) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int len = s.length();
		for(int i=0; i<len;i++) {
			char ch = Character.toLowerCase(s.charAt(i));
			if(ch == 'a' || ch =='e' || ch == 'i' ||ch =='o' || ch == 'u') {
				list.add(i);
			}
		}
		int vowelListLen = list.size(); 
		for(int i=0; i<vowelListLen/2;i++) {
			char tmp = s.charAt(list.get(vowelListLen -1 - i));
			s.setCharAt(list.get(vowelListLen -1 - i), s.charAt(list.get(i)));
			s.setCharAt(list.get(i), tmp);
		}
		if(vowelListLen%2 != 0) {
			char tmp = s.charAt(list.get(vowelListLen/2));
			s.setCharAt(list.get(vowelListLen/2), s.charAt(list.get((vowelListLen/2)-1)));
			s.setCharAt(list.get((vowelListLen/2)-1), tmp);
		}
		
		return s.toString();
	}
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("leetcode");
		System.out.println(reverseVowelsOfString(str));
	}

}
