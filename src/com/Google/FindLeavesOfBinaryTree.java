package com.Google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLeavesOfBinaryTree {

	 public static class TreeNode {
		     int val;
		     TreeNode left;
		      TreeNode right;
		     TreeNode() {}
		     TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		         this.left = left;
		          this.right = right;
		      }
		  }
	 public static int getLevel(TreeNode node, List<List<Integer>> list) {
		 if(node == null)  return -1;
		 int level = Math.max(getLevel(node.right, list), getLevel(node.left, list))+1;
		 
		 if(list.size() <= level) {
			 list.add(new ArrayList<Integer>());
		 }
		 list.get(level).add(node.val);
		 return level;
	 }
	public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        getLevel(root, list);
        return list;
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode left1 = new TreeNode(4);
		TreeNode right1 = new TreeNode(5);
		left.left = left1;
		left.right = right1;
		root.left = left;
		root.right = right;
		List<List<Integer>> output = findLeaves(root);
	}

}
