package com.Google;

public class EqualOneZero {

	public static int longestEqualSubArr(int[] arr) {
		int oneCount = 0, maxLen = 0;
		int n = arr.length;
		int idx = 0;
		for(int i=0; i<n;i++) {
			if(arr[i] == 1)
				oneCount++;
			else
				oneCount--;
			if(oneCount == 0) {
				
			}
				
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		1 0 1 0 1
//		1 1 -1 1 -1 1 
//		1 2 1 2 1 2
//		
//		1 1 0

	}

}
