package com.arrays.medium;

import java.util.HashMap;

public class ContainDuplicates2 {

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length,diff= 0;
        
        for(int i=0; i<n;i++) {
            if(map.containsKey(nums[i])) {
            	diff = Math.abs(i - map.get(nums[i]));
                if (diff <= k) return true;
                if(diff > k)map.put(nums[i], i);
            }else map.put(nums[i], i);
        }
        return false;
    }
	public static void main(String[] args) {
		int[] nums = {1,0,1,1};
		System.out.println(containsNearbyDuplicate(nums, 1));

	}

}
