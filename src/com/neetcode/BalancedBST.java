package com.neetcode;

public class BalancedBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static class Info {
		boolean isBal;
		int height;

		public Info(boolean isBal, int height) {
			this.height = height;
			this.isBal = isBal;
		}
	}

	public static Info helper(TreeNode root) {
		if (root == null)
			return new Info(true, 0);

		Info left = helper(root.left);
		Info right = helper(root.right);

		boolean isBal = left.isBal && right.isBal && (Math.abs(left.height - right.height) <= 1);
		int height = 1 + Math.max(left.height, right.height);
		return new Info(isBal, height);
	}

	public boolean isBalanced(TreeNode root) {
		return helper(root).isBal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
