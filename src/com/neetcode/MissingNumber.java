package com.neetcode;

public class MissingNumber {

	public static int missingNumber(int[] nums) {
        int ans = 0;
        int max = nums.length;
        
        for(int i=0; i< max; i++) {
            ans ^= nums[i];
        }
        for(int i=0; i<=max;i++) {
        	ans ^= i;
        }
        return ans;
    }
	public static void main(String[] args) {
		int[] arr = {0,1};
		System.out.println(missingNumber(arr));
	}

}
