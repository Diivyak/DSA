package com.neetcode;

public class KoKoEatingBananas {

	public static int isPossible(int[] arr, int speed) {
		int hourReq = 0;
		for(int i=0;i<arr.length;i++) {
			if(speed <= arr[i]) {
				hourReq += (arr[i]/speed);
				hourReq += (arr[i]%speed) != 0 ? 1 : 0;
			}
			else
				hourReq += 1;
		}
	return hourReq;

	}

	public static int minEatingSpeed(int[] arr, int h) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int n = arr.length;
		
		for(int i=0; i<n;i++) {
			min= Math.min(min, arr[i]);
			max= Math.max(max, arr[i]);
		}
		int ans = max;
		while(min <= max) {
			int mid = min +(min -max)/2;
			int reqHours = isPossible(arr, mid);
			if(reqHours <= h) {
				ans = Math.min(ans, mid);
				max = mid-1;
			}
			else {
				min = mid+1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
//		int[] arr = {30,11,23,4,20};
//		int[] arr = {30,11,23,4,20};
		int[] arr = {312884470};
				
		
		System.out.println(minEatingSpeed(arr, 312884469));

	}

}
