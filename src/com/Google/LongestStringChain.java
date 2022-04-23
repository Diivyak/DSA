package com.Google;

import java.util.Arrays;
import java.util.HashMap;

public class LongestStringChain {

	public static int longestStrChain(String[] words) { 
        HashMap<String, Integer> lenMap = new HashMap<String, Integer>();
        Arrays.sort(words, (a, b)-> a.length() - b.length());
     
        int maxLen = 0;
        for(String word: words) {
            lenMap.put(word, 1);
            
            
            int len = word.length();
            
            for(int i=0; i<len ;i++) {
            	StringBuilder s = new StringBuilder(word);
                String subStr = s.deleteCharAt(i).toString();
                
                if(lenMap.containsKey(subStr)) {
                    lenMap.put(word, Math.max(lenMap.get(word), lenMap.get(subStr)+1));
                }
            }
            
            maxLen = Math.max(maxLen, lenMap.get(word));
        }
        return maxLen;
    }
	public static void main(String[] args) {
		String[] words = {"ba","bca","bda","bdca","a","b"};
		
		System.out.println(longestStrChain(words));
	}

}
