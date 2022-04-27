package com.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] arr) {
		List<List<Integer>> output = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);

        for(int i=0; i<n-2;i++) {
            if(i==0 || (i> 0 && arr[i] != arr[i-1])) {
                int target = 0- arr[i];
                int left = i+1, right = n-1;

                while(left <right) {
                    if(arr[left] +arr[right] == target) {
                        output.add(Arrays.asList(arr[i], arr[left],arr[right]));

                        while(left<right && arr[left] == arr[left+1])  left++;

                        while(left<right && arr[right] == arr[right-1])  right--;

                        left++;
                        right--;
                    }
                    else if(arr[left]+ arr[right] > target) right--;
                    else left++;
                }
            
            }
        }

	    return output;

	}
	public static void main(String[] args) {
		int[] arr = {-1,0,1,2,-1,-4};
		List<List<Integer>> output = threeSum(arr);
		for(List<Integer> list: output) {
			for(Integer val: list) {
				System.out.print(val +" ");
			}
			System.out.println();
		}

	}

}
