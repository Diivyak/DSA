package com.neetcode;

import java.util.HashSet;

public class ContainsDuplicate {

	public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        int n = nums.length;
        
        for(int i=0; i<n;i++) {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
	public static void main(String[] args) {
		int[] arr = {1,2,3,1};
		System.out.println(containsDuplicate(arr));

	}

}
