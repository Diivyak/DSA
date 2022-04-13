package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

	public static ArrayList<String> output;
	public static void helper(int[] charArr, int idx, char[] result, int len) { 
		if(idx == len) {
			output.add(new String(String.valueOf(result)));
			return;
		}
		for(int i=0; i<26;i++) {
			if(charArr[i] != 0) {
				charArr[i]--;
				result[idx] = (char)(i + 'A');
				helper(charArr, idx+1,result, len);
				charArr[i]++;
			}
		}
	}
	public static List<String> getPermutations(String str) {
		output = new ArrayList<String>();
		int len = str.length();
		int[] charArr = new int[26];
		for(int i=0; i<len;i++) {
			charArr[str.charAt(i) - 'A']++;
		}
		char[] res = new char[len];
		helper(charArr, 0,res, len);
		return output;
	}
	public static void main(String[] args) {
		List<String> list = getPermutations("AABC");
		for(String str: list) {
			System.out.println(str);
		}
	}

}
