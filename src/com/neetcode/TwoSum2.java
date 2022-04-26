package com.neetcode;

public class TwoSum2 {

	public static  int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i=0, j = n-1;
        
        while(i <j) {
            int val = numbers[i] + numbers[j];
            if(val > target) j--;
            else if(val <target) i++;
            else return new int[]{i+1,j+1};
        }
        return new int[]{-1,-1};
    }
	public static void main(String[] args) {
		int[] arr = {2,7,11,15};
		int[] output = twoSum(arr, 9);
		System.out.println(output[0] +"-"+output[1]);

	}

}
