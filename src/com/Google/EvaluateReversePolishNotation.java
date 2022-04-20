package com.Google;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        Set<String> set = new HashSet<String>();
        set.add("+");set.add("-");set.add("*");set.add("/");
        int ans = 0;
        for(String s: tokens) {
            if(!set.contains(s)) {
                stack.add(Integer.parseInt(s));
            }else{
                int n1 = stack.pop(), n2 = stack.pop();
                if(s.equals("+")) ans = n1 +n2;
                else if(s.equals("-")) ans = n2-n1;
                else if(s.equals("*")) ans = n2*n1;
                else ans = n2/n1;
                stack.add(ans);
            }
        }
        return stack.pop();
        
    }
	public static void main(String[] args) {
//		String[] s = {"4","13","5","/","+"};
		String[] s = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		
		System.out.println(evalRPN(s));

	}

}
