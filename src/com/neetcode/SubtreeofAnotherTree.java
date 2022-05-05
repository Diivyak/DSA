package com.neetcode;

public class SubtreeofAnotherTree {
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
	public static boolean isEqual(TreeNode node, TreeNode subRoot) {
        if(node == null && subRoot == null)
            return true;
        if((node == null && subRoot != null) || (node != null && subRoot == null))
            return false;
        if(node.val != subRoot.val)
            return false;
        if(node.val == subRoot.val)
            return isEqual(node.left, subRoot.left) && isEqual(node.right, subRoot.right);
        else
            return isEqual(node.left, subRoot) || isEqual(node.right, subRoot);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        if(isEqual(root, subRoot))
            return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
