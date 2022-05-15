package com.arrays.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetercombination {

	public static List<String> output;
    public static void helper(String digits, int idx, HashMap<Integer,ArrayList<Character>> map, 
                              StringBuilder sb, int n) {
        
        if(idx >= n) {
            output.add(new String(sb.toString()));
            return;
        }
        int d = Integer.parseInt(""+digits.charAt(idx));
        System.out.println("digit=="+d);
        for(Character ch: map.get(d)) {
                sb.append(ch);
                helper(digits, idx+1, map,sb, n);
                sb.setLength(sb.length()-1);
        }
        
        
    }
    public static List<String> letterCombinations(String digits) {
        output = new ArrayList<>();
        HashMap<Integer, ArrayList<Character>> map = new HashMap<Integer, ArrayList<Character>>();
        
        int ch = 97;
        int j = 3;
        for(int i=2; i<= 9;i++) {
            if(i == 7 || i== 9) 
                j = 4;
            else j = 3;
            map.put(i, new ArrayList<Character>());
            for(int k=0; k<j;k++) {
                map.get(i).add((char)ch);
                ch++;
            }
        }
        helper(digits, 0, map, new StringBuilder(""), digits.length());
        return  output;
        
    }
	public static void main(String[] args) {
		letterCombinations("2");

	}

}
