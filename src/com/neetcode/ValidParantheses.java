package com.neetcode;

import java.util.Stack;

public class ValidParantheses {

	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int n = s.length();
        
        for(int i=0; i<n;i++) {
            char ch = s.charAt(i);
            if((ch == ')' && (!stack.isEmpty() && stack.peek() == '(')) ||
            	(ch == '}' && (!stack.isEmpty() && stack.peek() == '{')) || 
            	(ch == ']' && (!stack.isEmpty() && stack.peek() == '[')) ) {
            	stack.pop();
            	continue;
            }
            stack.push(ch);
            
        }
        if(stack.isEmpty()) 
            return true;
        
        return false;
    }
	public static void main(String[] args) {
		String str = "()";
		System.out.println(isValid(str));

	}

}
