package com.arrays.medium;

import java.util.HashMap;

public class ContainsDuplicate3 {

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length,diff= 0;
        
        for(int i=0; i<n;i++) {
            if(map.containsKey(nums[i])) {
            	diff = Math.abs(i - map.get(nums[i]));
                if (diff <= k) return true;
                if(diff > k)map.put(nums[i], i);
            }else {
            	for(int j=0; j<t;j++) {
            		map.put(Math.abs(nums[i]+j), i);
            		map.put(Math.abs(nums[i]-j), i);
            	}
            	
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[] arr = {8,7,15,1,6,1,9,15};
		int k= 1, t=3;
		System.out.println(containsNearbyAlmostDuplicate(arr, k, t));
	}

}
