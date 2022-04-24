package com.arrays.easy;

public class SortingString {

	public static String sortSentence(String s) {
        String[] strArr = s.split(" ");
        int n = strArr.length;
        
        String[] output = new String[n];
        for(int i=0; i<n; i++) {
            int seq = (int)strArr[i].charAt(strArr[i].length()-1)-'0';
            output[seq-1] =  strArr[i].substring(0,strArr[i].length()-1) +" ";
        }
        StringBuilder ans= new StringBuilder("");
        for(String str: output)  ans.append(str);
        return ans.toString();
    }
	public static void main(String[] args) {
		System.out.println(sortSentence("is2 sentence4 This1 a3"));

	}

}
