package com.neetcode;

import java.util.Stack;

public class MinStack {
 public static class MinStackCls {
	 public static Stack<Integer> stack;
	    public static Stack<Integer> minStack;
	    public MinStackCls() {
	        stack = new Stack();
	        minStack = new Stack();
	    }
	    
	    public void push(int val) {
	        Stack<Integer> tempStack = new Stack<Integer>();
	        while(!minStack.isEmpty() && minStack.peek() < val) {
	            tempStack.push(minStack.pop());
	        }
	        minStack.push(val);
	        while(!tempStack.isEmpty()) {
	            minStack.push(tempStack.pop());
	        }
	        stack.push(val);
	        
	    }
	    
	    public void pop() {
	        if(!stack.isEmpty()) stack.pop();
	    }
	    
	    public int top() {
	        return !stack.isEmpty() ? stack.peek() : 0;
	    }
	    
	    public int getMin() {
	        // int minVal = Integer.MAX_VALUE;
	        // Stack<Integer> tempStack = new Stack<Integer>();
	        // while(!stack.isEmpty()) {
	        //     minVal = Math.min(minVal, stack.peek());
	        //     tempStack.add(stack.pop());
	        // }
	        // while(!tempStack.isEmpty()) {
	        //     stack.push(tempStack.pop());
	        // }
	        return minStack.peek();
	    }
 }
	public static void main(String[] args) {
		String[] instructions = {"MinStack","push","push","push","getMin","pop","top","getMin"};
		int[][] input = {{},{-2},{0},{-3},{},{},{},{}};
		MinStackCls stack = null;
		int k = 0;
		for(String event: instructions) {
			if(event.equals("MinStack" )) {
				stack = new MinStackCls();
			}else if(event.equals("push" )) {
				stack.push(input[k][0]);
			}else if(event.equals("getMin" )) {
				System.out.println(stack.getMin());
			}else if(event.equals("top" )) {
				System.out.println(stack.top());
			}else {
				stack.pop();
			}
			k++;
		}

	}

}
