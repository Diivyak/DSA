package com.neetcode;

public class Pow {

	public static double myPowHelper(double x, int n) {
        if(n == 0)
            return x;
        double half = myPowHelper(x, n/2);
        if(n %2 ==0) 
            return half* half;
        else
            return half * half * x;
        
    }
    public static  double myPow(double x, int n) {
        double res = myPowHelper(x, Math.abs(n));
        return (n > 0) ? res : 1/res;
    }
    
	public static void main(String[] args) {
		
		System.out.println(myPow(2.00, 10));

	}

}
