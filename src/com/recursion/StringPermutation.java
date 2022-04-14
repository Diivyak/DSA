package com.recursion;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class StringPermutation {
	public static HashSet<String> output;
	public static void helper(String str, int idx, String result) {
		for(int i=idx; i<str.length();i++) {
			result += str.charAt(i);
			output.add(result);
			helper(str, i+1, result);
			result = result.substring(0,result.length()-1);
		}
	}
	public static HashSet<String> getPermutations(String str) {
		output = new LinkedHashSet<String>();
		helper(str, 0, "");
		return output;
	}
	public static void main(String[] args) {	
		HashSet<String> list = getPermutations("AABC");
		for(String ele: list) {
			System.out.println(ele);
		}
	}

}
