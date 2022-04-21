package com.Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindAndReplaceInStr {

	public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Set<Integer> set = new HashSet<Integer>();
        HashMap<Integer,String[]> map = new HashMap<Integer,String[]>();
        
        int n = s.length();
        int t = indices.length;
        
        for(int i=0; i<t;i++) {
        	set.add(indices[i]);
        	map.put(indices[i], new String[] {sources[i], targets[i]});
        }
        
        int i=0;
        StringBuilder sb = new StringBuilder("");
        while(i <n) {
            if(set.contains(i))  {
            	String src = map.get(i)[0];
                int len = src.length();
                String tar = map.get(i)[1];
                if(s.substring(i, i+len).equals(src)) {
                    sb.append(tar);
                    i = i+len;
                    continue;
                }
            }
            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
//		 "abcd", indices = [0, 2], sources = ["ab","ec"], targets = ["eee","ffff"]
//		"vmokgggqzp"
//		[3,5,1]
//		["kg","ggq","mo"]
//		["s","so","bfr"]

		System.out.println(findReplaceString("vmokgggqzp", new int[]{3,5,1},new String[]{"kg","ggq","mo"},new String[]{"s","so","bfr"})); 

	}

}
