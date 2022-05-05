package com.neetcode;

import java.util.HashMap;

public class SubstringsofSizeThreewithDistinctCharacters {

	public static int countGoodSubstrings(String s) {
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int n = s.length();
        if(n < 3)
            return 0;
        int subStrCount = 0;
        for(int i=0; i<3;i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        if(map.size() == 3)
            subStrCount++;
        
        for(int i=1; i<=n-3;i++){
            char ch = s.charAt(i-1);
            if(map.get(ch) == 1) map.remove(ch);
            else map.put(ch, map.get(ch)-1);
            ch = s.charAt(3+i-1);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            
            if(map.size()==3) 
                subStrCount++;
            
        }
        return subStrCount;
    }
	public static void main(String[] args) {
		String s = "x";
		System.out.println(countGoodSubstrings(s));

	}

}
