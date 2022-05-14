package com.recursion;

import java.util.HashMap;

public class CombinationSum4 {

	public static HashMap<Integer, Integer> map;
    public static int helper(int[] nums, int target, int sum ) {
        if(sum == target) {
            return 1;
        }
        if(map.containsKey(sum)) {
            return map.get(sum);
        }
        int count = 0;
        for(int i=0; i<nums.length;i++) {
            if((sum + nums[i]) <= target)
                count += helper(nums, target, sum + nums[i]);
        }
        map.put(sum, count);
        return count;
    }
    public static int combinationSum4(int[] nums, int target) {
        map = new HashMap<>();
        return helper(nums,target,0);
    }
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		System.out.println(combinationSum4(arr, 4));

	}

}
