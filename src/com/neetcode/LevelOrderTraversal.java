package com.neetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

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
	public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> output = new ArrayList<>();
        if(root == null) return output;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<size;i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            output.add(list);
            
        }
        return output;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
