package com.Google;

import java.util.Stack;

public class DecodeString {

	public static String decodeString(String s) {
        Stack<String> stack = new Stack<String>();
        
        int n = s.length(), i=0;
        StringBuilder sb = new StringBuilder("");
        while(i<n) {
            
            while(s.charAt(i) != '[') {
            	sb.append(s.charAt(i));
                i++;
            }
            stack.add(sb.toString());
            stack.add("[");
            i++;
            
            sb = new StringBuilder("");
            while(s.charAt(i) != ']') {
            	sb.append(s.charAt(i));
                i++;
            }
            stack.add(sb.toString());
            
            if(s.charAt(i) == ']') {
                sb = new StringBuilder("");
                String str = "";
                while(stack.peek() != "[") {
                    str = stack.pop();
                }
                stack.pop();
                int freq = Integer.parseInt(stack.pop());
                for(int j=0; j<freq; j++) {
                    sb.append(str);
                }
                stack.add(sb.toString());
                i++;
            }
            
        }
        String str = "";
        while(!stack.isEmpty() && stack.peek() != "[") {
                    if(stack.peek() == "[") {
                    	stack.pop();
                    	int freq = Integer.parseInt(stack.pop());
                        for(i=0; i<freq; i++) {
                            sb.append(str);
                        }
                        return sb.toString();
                    }else {
                    	str = stack.pop();
                    }
        }
        return sb.toString();
    }
	public static void main(String[] args) {
//		System.out.println(decodeString("3[a]"));
		System.out.println(decodeString("3[a]2[bc]"));

	}

}
