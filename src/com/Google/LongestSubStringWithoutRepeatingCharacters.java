package com.Google;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int n = s.length();
        int i=0, j=0;
        
        HashSet<Character> set = new HashSet<Character>();
        
        while(i < n) {
            char ch = s.charAt(i);
            if(set.contains(ch)) {
                maxLen = Math.max(maxLen, set.size());
                while(j <n && s.charAt(j) != ch) {
                	
                	set.remove(s.charAt(j));
                	j++;
                }
                j++;
            }
            set.add(ch);
            i++;
        }
        maxLen = Math.max(maxLen, set.size());
        return maxLen;
    }
	public static void main(String[] args) {
		String s = " ";
//		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));

	}

}
