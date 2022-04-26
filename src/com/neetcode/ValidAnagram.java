package com.neetcode;

public class ValidAnagram {

	public static boolean isAnagram(String s, String t) {
        int[] charArr = new int[26];
        int n = s.length(), m = t.length();
        
        if(n != m) return false;
        
        for(int i=0;i<n;i++) charArr[s.charAt(i) - 'a']++;
        for(int i=0;i<n;i++) charArr[t.charAt(i) - 'a']--;
        
        for(int i=0; i<26;i++) if(charArr[i] != 0) return false;
        
        return true;
    }
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		System.out.println(isAnagram(s, t));
	}

}
