package com.Google;

public class SubArrWithGivenSum {

	public static int getCountOfSubArrWithSum(int[] arr, int target) {
		
		int n= arr.length, count = 0, i = 0, j=0, sum = 0;
		
		while(j <n) {
			if(i < n) 
				sum += arr[i];
			else 
				j++;
			if(sum== target)
				count++;
			if(sum >= target && j <n) {
				sum -= arr[j];
				j++;
				if(sum == target)
					count++;
			}
			i++;
		}
		return count;
	}
	public static void main(String[] args) {
		int[] arr = {1, 0 ,1, 0, 1};
//		1
//		1 0
//		0 1
//		1
//		0 1 0
//		1 0
//		0 1
//		1
		System.out.println(getCountOfSubArrWithSum(arr, 1));

	}

}
