package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

	public static List<List<Integer>> output;
    public static void helper(int k, int val, int target, ArrayList<Integer> temp, int sum) {
    	
        if(temp.size() == k) {
            if(target == sum) {
                output.add(new ArrayList<>(temp));
                return;
            }
            return;
        }
        
        for(int i = val; i<10; i++) {
            temp.add(i);
            helper(k, i+1, target+i, temp,sum);
            temp.remove(temp.size()-1);
        }
        
    }
    public static  List<List<Integer>> combinationSum3(int k, int n) {
        output = new ArrayList<>();
        helper(k, 1, 0, new ArrayList<Integer>(), n);
        return output;
    }
	public static void main(String[] args) {
		combinationSum3(3, 7);
		for(List<Integer> list: output) {
			for(Integer ele: list) {
				System.out.print(ele+" ");
			}
			System.out.println();
		}

	}

}
