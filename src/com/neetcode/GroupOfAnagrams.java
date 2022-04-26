package com.neetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GroupOfAnagrams {

	public static void constructCharCount(int[][] charArr, String str, int idx) {
        int n = str.length();
        for(int i=0; i<n;i++) charArr[idx][str.charAt(i)-'a']++;
        
    }
    public static HashSet<String> set;
    public static void getAnagrams(int[][] charArr, String[] strs, int idx,ArrayList<String> list ) {
        int n = strs.length;
        for(int i=0; i<n;i++) {
            if(idx != i) {
                boolean isAnagram = true;
                for(int j=0; j<26;j++) {
                    if(charArr[i][j] != charArr[idx][j]) 
                    { 
                        isAnagram = false; 
                        break;
                    }
                }
                if(isAnagram) {
                    set.add(strs[i]);
                    list.add(strs[i]);
                }
            }
        }
        list.add(strs[idx]);
        set.add(strs[idx]);
        return;
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        int[][] charArr = new int[n][26];
        set = new HashSet<String>();
        
        for(int i=0; i<n;i++) {
            constructCharCount(charArr, strs[i], i);
        }
        
        List<List<String>> output = new ArrayList<>();
        for(int i=0; i<n;i++) {
        	ArrayList<String> list = new ArrayList<String>();
            if(!set.contains(strs[i])) {
                getAnagrams(charArr, strs, i, list);
                output.add(list);
            }
            
        }
        return output;
        
    }
    
    
    public static List<List<String>> getAnagram1(String[] strs) {
    	List<List<String>> output = new ArrayList<>();
    	HashMap<String, ArrayList<String>> map = new HashMap<>();
    	for(String s: strs) {
    		char[] hash = new char[26];
    		for(int i=0; i<s.length(); i++) hash[s.charAt(i)-'a']++;
    		String hashStr = new String(hash);
    		if(!map.containsKey(hashStr)) {
    			map.put(hashStr, new ArrayList<String>());
    		}
    		map.get(hashStr).add(s);

    	}
    	output.addAll(map.values());

    	return output;

    }

    
	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> list = getAnagram1(strs);
		for(List<String> strList : list) {
			for(String s: strList) {
				System.out.print(s+" ");
			}
			System.out.println();
		}
	}

}
