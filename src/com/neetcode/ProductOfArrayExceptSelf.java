package com.neetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result =new int[n];
        
        Arrays.fill(result, 1);
        int prefix = 1;
        for(int i=0; i<n;i++) {
            result[i] *= prefix;
            prefix *= nums[i];
        }
        prefix = 1;
        for(int j=n-1; j>= 0;j--){
            result[j] *= prefix;
            prefix *= nums[j];
        }
        return result;
    }
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		nums = productExceptSelf(nums);
		for(int n: nums) System.out.print(n+" ");

	}

}
