package com.neetcode;

public class MultiplyString {

	public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1 > len2)
            multiply(num2, num1);
        int carry = 0;
        long finalSum = 0;
        for(int i=len2-1 ; i>=0; i--) {
            long sum = 0;
            for(int j=len1-1; j>= 0;j--) {
            	int n1 = Character.getNumericValue(num2.charAt(i));
            	int n2 = Character.getNumericValue(num1.charAt(j));
                carry = carry + (n1 * n2);
                if(carry > 9) {
                    sum += (int) (carry%10)* Math.pow(10, (len1-1-j));
                    carry = carry/10;
                }else{
                    sum += (int) (carry*Math.pow(10, len1-1-j));
                    carry = 0;
                }
            }
            if(carry > 0) {
            	sum += (int) (carry * (Math.pow(10, len2-1-i )));
            	carry = 0;
            }
            finalSum += sum * (Math.pow(10, len2-1-i));
            
        }
        return finalSum+"";
        
        
    }
	public static void main(String[] args) {
//		"123456789"
//		"987654321"
//		"121932631112635269"
//		 10821521012635268
		System.out.println(multiply("123456789", "987654321"));

	}

}
