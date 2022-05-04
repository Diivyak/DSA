package com.neetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ValidBST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	public static boolean isValidBSTHelper(TreeNode node, int left, int right) {
        if(node == null)
            return true;
        if(node.val >= right || node.val <= left)
            return false;
        return isValidBSTHelper(node.left, left, node.val) && isValidBSTHelper(node.right, node.val, right);
    }
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static TreeNode constructTree(int[] arr) {
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	TreeNode root =new TreeNode(arr[0]);
    	q.add(root);
    	int i=1;
    	while(!q.isEmpty() && i <arr.length) {
    		
    		TreeNode node = q.poll();
    		
    		node.left = arr[i] == -1 ? null : new TreeNode(arr[i]);
    		i++;
    		node.right = arr[i] == -1 ? null : new TreeNode(arr[i]);
    		i++;
    		if(node.left != null)
    			q.add(node.right);
    		if(node.right != null)
    			q.add(node.right);
    	}
    	return root;
    }
	public static void main(String[] args) {
		

//		int[] arr = {5,4,6,-1,-1,3,7};
		int[] arr = {5,1,4,-1,-1,3,6};
		TreeNode root = null;
		root = constructTree(arr);
		
		System.out.println(isValidBST(root));

	}

}
