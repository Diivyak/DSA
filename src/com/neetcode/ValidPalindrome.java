package com.neetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidPalindrome {

//	public static boolean isPalindrome(String s) {
//		int n = s.length();
//        s= s.toLowerCase();
//        int i=0, j = n-1;
//        while(i < j) {
//            char start = s.charAt(i);
//            char end = s.charAt(j);
//            if((start < 'a' || start > 'z') && (start < '0' || start > '9')){
//                i++;
//                continue;
//            }
//            if((end < 'a' || end > 'z') && (end < '0' || end > '9')){
//                j--;
//                continue;
//            }
//            if(s.charAt(i++) != s.charAt(j--)) return false;
//        }
//        return true;
//    }
	
	public static int efficientJanitor(List<Float> weight) {
        int n = weight.size();
        int trips = 1;
        Collections.sort(weight);
        float prev = weight.get(0);
        for(int i=1; i<n;i++) {
            while(i <n && (prev + weight.get(i))<= 3) {
                
                prev = weight.get(i);
                i++;
            }
            if(i <n) {
	            prev = 0;
	            i--;
	            trips += 1;
            }
        }
        if(prev != 0)trips++;
        return trips;

    }
	
	public static void main(String[] args) {
//		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//		System.out.println(isPalindrome("race a car"));
//		System.out.println(isPalindrome(".,"));
//		System.out.println(isPalindrome("0P"));
		float[] arr = {1.01f,1.99f,2.5f,1.5f,1.01f};
//		float[] arr = {1.01f,1.991f,1.32f,1.4f};
		List<Float> list = new ArrayList<Float>();
		for(int i=0; i<arr.length;i++)
			list.add(arr[i]);
		System.out.println(efficientJanitor(list));
	}

}
