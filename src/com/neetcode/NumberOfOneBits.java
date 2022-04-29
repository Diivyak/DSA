package com.neetcode;

public class NumberOfOneBits {

	public static int hammingWeight(int n) {
        int count  =0;
        while(n>0) {
            count += n&1;
            n /= 2;
        }
        return  count;
    }
	
	public static void main(String[] args) {
		System.out.println(hammingWeight(00000000000000000000000000001011));

	}

}
