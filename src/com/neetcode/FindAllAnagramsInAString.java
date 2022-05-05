package com.neetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

	public static boolean isAnagram(int[] sCharCount , int[] pCharCount) {
        for(int i=0; i<26;i++) {
            if(sCharCount[i] != pCharCount[i])
                return false;
        }
        return true;
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int[] sCharCount = new int[26];
        int[] pCharCount = new int[26];
        List<Integer> output = new ArrayList<Integer>();
        int sLen = s.length();
        int pLen = p.length();
        
        if(pLen > sLen)
            return output;
        
        for(int i=0; i<pLen;i++) 
            pCharCount[p.charAt(i) - 'a']++;
        
        for(int i=0; i<pLen;i++) {
            sCharCount[s.charAt(i) - 'a']++;
        }
        if(isAnagram(sCharCount, pCharCount))
            output.add(0);
        
        for(int i=1; i<=sLen-pLen;i++) {
            sCharCount[s.charAt(i-1)-'a']--;
            sCharCount[s.charAt(pLen + i-1)-'a']++;
            if(isAnagram(sCharCount, pCharCount)){
                output.add(i);
            }
        }
        return output;
    }
	public static void main(String[] args) {
//		"cbaebabacd"
//		"abc"
		String s = "cbaebabacd";
		String t = "abc";
		List<Integer> output = findAnagrams(s, t);
		for(int ele: output)
			System.out.print(ele+" ");
	}

}
