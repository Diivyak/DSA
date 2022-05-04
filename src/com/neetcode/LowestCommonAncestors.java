package com.neetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestors {

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
	public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
		TreeNode cur = root;

		while (cur != null) {
			if (p > cur.val && q > cur.val) {
				cur = cur.right;
			} else if (p < cur.val && q < cur.val) {
				cur = cur.left;
			} else if ((p == cur.val) || (p < cur.val && q > cur.val)) {
				return cur;
			} else {
				return cur;
			}
		}
		return null;
	}
	
	public static TreeNode constructTree(int[] arr, int idx, TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int i=0;
		root = new TreeNode(arr[i]);
		q.add(root);
		int n = arr.length;
		i++;
		while(!q.isEmpty() && i<n) {
			TreeNode innerNode = q.poll();
			
			innerNode.left = arr[i] == -1 ? null : new TreeNode(arr[i]);
			i++;
			innerNode.right = arr[i] == -1 ? null : new TreeNode(arr[i]);
			i++;
			if(innerNode.left != null)
				q.add(innerNode.left);
			if(innerNode.left != null)
				q.add(innerNode.right);
		}
		return root;
	}

	public static void main(String[] args) {
		int[] arr = {3,5,1,6,2,0,8,-1,-1,7,4};
//		[3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
		TreeNode root = null;
		root = constructTree(arr, 0, root);
		
		TreeNode node = lowestCommonAncestor(root, 5, 4);
		System.out.println(node.val);
	}

}
