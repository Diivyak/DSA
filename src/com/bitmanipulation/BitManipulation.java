package com.bitmanipulation;

public class BitManipulation {

	public static void main(String[] args) {
//		System.out.println(getBinaryRepresentation(2147483649L));
//		System.out.println(getEleThatAppearsOnce(new int[]{12, 1, 12, 3, 12, 1, 1, 2, 3, 3}));

		// Array contains all elements appearing even number of times expect one element in odd number of times.
//		System.out.println(getEleThatOccursOddTimes(new int[] {1,1,2,2,3,4,6,3,7,6,6,6,8,7,8}));
		
//		System.out.println(getRightMostSetBit(136));
//		System.out.println(getNonRepeatingNumbers(new int[] {2,11,3,11,7,3,9,2}));
		
		System.out.println(isOppSigns(100, -100));
	}
	
	public static int getEleThatAppearsOnce(int[] arr) {
		int ans = 0, n = arr.length;
		
		for(int i=0; i<32;i++) {
			int count = 0;
			int x = (1<<i);
			for(int j=0; j<n;j++) {
				int bit = arr[j] & x;
				if(bit != 0) {
					count++;
				}
			}
			if(count%3 != 0) {
				ans = ans | x; 
			}
		}
		return ans;
	}
	
	public static int getRightMostSetBit(int n) {
		int pos = 0;
		for(int i=0; i<32;i++) {
			if((n &(1<<i)) == 0) {
				pos++;
			}else {
				break;
			}
		}
		return pos;
	}
	
	// Array contains all elements appearing even number of times expect one element in odd number of times.
	public static int getEleThatOccursOddTimes(int[] arr) {
		int n = arr.length;
		int ans = 0;
		for(int i=0; i<32; i++) {
			int count = 0;
			int x = (1<<i);
			for(int j=0; j<n;j++) {
				int bit = arr[j] & x;
				if(bit != 0) {
					count++;
				}
			}
			if(count %2 != 0) {
				ans = ans | x;
			}
		}
		return ans;
	}
	
	
	// Binary representation
	public static String getBinaryRepresentation(long n) {
		String ans = "";
		for(int i=0; i<32;i++) {
			long bit = n&1;
			n = (n>>1);
			ans = String.valueOf(bit) + ans;
		}
		return ans;
	}
	
	public static int[] getNonRepeatingNumbers(int[] arr) {
		int ans = 0;
		for(int ele: arr) {
			ans ^= ele;
		}
//		int rightMostSetBitPos = getRightMostSetBit(ans);
		ans = ans & ~(ans-1);
		int num1 = 0, num2 = 0;
		for(int ele: arr) {
//			if((ele & (1<<rightMostSetBitPos)) == 0) {
			if((ele & ans) == 0) {
				num1 ^= ele;
			}else {
				num2 ^= ele;
			}
		}
		
		return num1 < num2 ? new int[] {num1, num2} : new int[] {num2, num1};
	}
	
	public static boolean isOppSigns(int a, int b) {
		// Check MSB, if MSB = 1 number is negative else positive
		boolean aSignPos = ((a & (1 <<31)) == 0);
		boolean bSignPos = ((b & (1 <<31)) == 0);
		return aSignPos != bSignPos;
		
	}

}
