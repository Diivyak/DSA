package com.bitmanipulation;

public class BitManipulation {


	
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
	public static String getBinaryRepresentation(int n) {
		String ans = "";
		for(int i=0; i<32;i++) {
			int bit = n&1;
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
	
	static boolean oppositeSigns(int x, int y)
	{
	    return ((x ^ y) >> 31) == 1;
	}
	public static boolean isOppSigns(int a, int b) {
		// Sol#1 - Check MSB, if MSB = 1 number is negative else positive
//		boolean aSignPos = ((a & (1 <<31)) == 0);
//		boolean bSignPos = ((b & (1 <<31)) == 0);
//		return aSignPos != bSignPos;
//		
		
		//Sol#2 - If integers are of opposite sign then XOR of a & b is always negative because the MSB for one of the number is set.
		// When we do XOR of two numbers with opposite sign then it's MSB will be set that is it will be negative number.
//		return ((a^b) < 0);
		
		//Sol#3 - Do XOR of given numbers then check if 32th bit is set to 1 or not.
		// If the bit set to 1 then both are of opposite sign.
		System.out.println(getBinaryRepresentation(a));
		System.out.println(getBinaryRepresentation(b));
		
		System.out.println(getBinaryRepresentation(a^b));
		System.out.println(getBinaryRepresentation(1<<31));
//		return ((a^b) & (1<<31)) != 0;
		return (((a^b)>>31) & (1)) == 1;
		
	}
	
	public static int addOne(int n) {
		int bit = 1;
		System.out.println(getBinaryRepresentation(n));
		while((n & bit) == 1) {
			 n ^= bit;
			 System.out.println(getBinaryRepresentation(n));
			 bit = bit<<1;
		}
		System.out.println(getBinaryRepresentation(n));
		n |= bit;
		System.out.println(getBinaryRepresentation(n));
		return n;
	}
	
	public static int multipleNumWithThreeDotFive(int n) {
		// n * (3.5) = (2n + n + n/2);
		
		return (n<<1) + n + (n>>1);
		
	}
	
	public static int turnOffRightMostSetBit(int n) {
		int bit = 0, val = n;
		System.out.println(getBinaryRepresentation(n));
		while(((n>>bit) & 1) != 1) {
			bit++;
//			n <<= 1;
			System.out.println(getBinaryRepresentation(n));
			System.out.println(getBinaryRepresentation(bit));
		}
//		System.out.println(getBinaryRepresentation(bit));
//		n = (n<<bit) ^ 0;
//		System.out.println(getBinaryRepresentation(n));
		return n;
	}
	public static void main(String[] args) {
//		System.out.println(getBinaryRepresentation(2147483649L));
//		System.out.println(getEleThatAppearsOnce(new int[]{12, 1, 12, 3, 12, 1, 1, 2, 3, 3}));

		// Array contains all elements appearing even number of times expect one element in odd number of times.
//		System.out.println(getEleThatOccursOddTimes(new int[] {1,1,2,2,3,4,6,3,7,6,6,6,8,7,8}));
		
//		System.out.println(getRightMostSetBit(136));
//		System.out.println(getNonRepeatingNumbers(new int[] {2,11,3,11,7,3,9,2}));
		
//		System.out.println(isOppSigns(100, -100));
//		System.out.println(addOne(10));
		System.out.println(multipleNumWithThreeDotFive(11));
//		System.out.println(turnOffRightMostSetBit(12));
	}
}
