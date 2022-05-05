package com.neetcode;

public class KthMissingPositiveNumber {

	public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int i=1;
        
        for(int j=0; j<n;j++) {
            while(i < arr[j]) {
                k--;
                if(k == 0) return i;
                i++;
            }
            i++;
        }
        return -1;
    }
	public static void main(String[] args) {
		int[] arr = {2,3,4,7,11};
		System.out.println(findKthPositive(arr, 5));

	}

}
