package com.neetcode;

import java.util.HashMap;

public class MinimumWindowSubString {

	public static String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if(sLen < tLen)
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        int have = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        for(int i=0; i<tLen;i++) {
            char  ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int j = 0;
        for(int i=0; i<sLen;i++) {
            char  ch = s.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0) have++;
            }

            while(have == map.size()) {
                if(len > (i-j+1)) {
                    start = j;
                    len = (i-j+1);
                }
                ch = s.charAt(j);
                j++;
                if(map.containsKey(ch)) {
                    if(map.get(ch) == 0) have--;
                    map.put(ch, map.get(ch)+1);
                }

            }
        }
        return len >sLen ? "" : s.substring(start, start+len);


        
    }
	public static void main(String[] args) {
		String s = "ADOBECODEBANC", t = "ABBC";
		System.out.println(minWindow(s,t));	

	}

}
