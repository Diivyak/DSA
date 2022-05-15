package com.arrays.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberII {

	public static List<String> output;
    public static void helper(int idx, int n, char[] charArr, HashMap<Character,Character> map, int totalDigit,List<String> output) {
        if(idx == n) {
            int i = idx;
            while(i > 0) {
                charArr[totalDigit-i] = map.get(charArr[i-1]);
                i--;
            }
            StringBuilder sb = new StringBuilder("");
        	
            
            for(int j=0; j<charArr.length; j++) {
        		sb.append(charArr[j]);
        	}
            if(totalDigit%2 != 0) {
            	sb.setCharAt(n, '0');
                output.add(new String(sb.toString()));
                sb.setCharAt(n, '1');
                output.add(new String(sb.toString()));
                sb.setCharAt(n, '8');
                output.add(new String(sb.toString()));
                
            }else {
            	output.add(new String(sb.toString()));
            }
            return;
        }
        for(Map.Entry<Character, Character> entry: map.entrySet()) {
            charArr[idx] = entry.getKey();
            helper(idx+1, n, charArr,map, totalDigit,output);
        }
    }
    public static List<String> findStrobogrammatic(int n) {
    	output = new ArrayList<String>();
    	if(n ==1) {
    		output.add("0");output.add("1");output.add("6");output.add("8");output.add("9");
    		return output;
    	}
        
        char[] charArr = new char[n];
        HashMap<Character, Character> map = new HashMap<>();
//        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        helper(0,n/2, charArr, map, n,output);
        return output;
    }
	public static void main(String[] args) {
		System.out.println(findStrobogrammatic(1));

	}

}
