package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {

	public static void helper(List<List<Integer>> output, int idx, int target, List<Integer> temp, int[] freq, int[] candidates) {
        if(idx >= candidates.length) {
            if(target == 0) {
                output.add(new ArrayList<>(temp));
            }
            return;
        }
        if(target == 0) {
            output.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx; i<candidates.length; i++) {
            if(freq[i] > 0) {
                freq[i]--;
                temp.add(candidates[i]);
                helper(output, idx+1, target-candidates[i], temp, freq, candidates);
                temp.remove(temp.size()-1);
                freq[i]++;
                helper(output, idx+1, target, temp, freq, candidates);
            }
        }
    }
    public static  List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output  = new ArrayList<>();
        int n = candidates.length;
        int[] freq = new int[51];
        
        for(int i=0; i<n;i++) {
            freq[candidates[i]]++;
        }

        helper(output, 0, target, new ArrayList<Integer>(), freq, candidates);
        
        return output;
    }	
	public static void main(String[] args) {
		int[] arr = {10,1,2,7,6,1,5};
		List<List<Integer>> output = combinationSum2(arr, 8);
		
		for(List<Integer> list: output) {
			for(Integer ele: list) {
				System.out.print(ele+" ");
			}
			System.out.println();
		}

	}

}
