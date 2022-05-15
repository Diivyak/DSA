package com.arrays.easy;

import java.util.HashMap;

public class StringsDifferByOneCharacter {

	public static boolean isSame(String first, String second) { 
        int count = 0;
        int len = first.length();
        for(int i=0; i<len;i++) {
        	if(first.charAt(i) != second.charAt(i)) {
        		count++;
        	}
        }
        return count == 1 ? true: false;
    }
    public static boolean differByOne(String[] dict) {
        int len = dict.length;
        HashMap<String, int[]> map = new HashMap<>();
        for(String s: dict) {
            int[] charCount = new int[26];
            for(char ch : s.toCharArray()) {
                charCount[ch-'a']++;
            }
            map.put(s, charCount);
        }
        
        for(int i=0; i<len; i++) { 
            String input = dict[i];
            for(int j=0; j<len ;j++) {
                if( i!= j) {
                    if(isSame(input, dict[j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
	public static void main(String[] args) {
		String[] dict = {"abcd","acbd", "aacd"};
		System.out.println(differByOne(dict));

	}

}
