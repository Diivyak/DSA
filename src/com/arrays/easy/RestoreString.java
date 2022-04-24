package com.arrays.easy;

public class RestoreString {

	public static String restoreString(String s, int[] indices) {
        int n =  indices.length;
        StringBuilder restoreStr = new StringBuilder(s);
        
        for(int i=0; i<n;i++) {
        	restoreStr.setCharAt(indices[i], s.charAt(i));
        }
        
        return restoreStr.toString();
    }
	public static void main(String[] args) {
//		"aiohn"
//		[3,1,4,2,0]
		String str = "aiohn";
		int[] indices = {3,1,4,2,0};
		System.out.println(restoreString(str, indices));

	}

}
