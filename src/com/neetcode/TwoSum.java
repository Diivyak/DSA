package com.neetcode;

import java.util.HashMap;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<n;i++) {
            if(map.containsKey(nums[i])) return new int[] {map.get(nums[i]), i};
            else map.put(target-nums[i], i); 
        }
        return new int[]{-1,-1};

    }
	public static void main(String[] args) {
		int[] arr = {2,7,11,15};
		int target = 9;
		int[] output = twoSum(arr, target); 
		System.out.println(output[0] +" "+output[1]);

	}

}
