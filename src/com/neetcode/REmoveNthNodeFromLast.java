package com.neetcode;

import com.neetcode.ReOrderList.ListNode;

public class REmoveNthNodeFromLast {

	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        int numOfNodes = 0;
        ListNode cur = head;
        
        while(cur != null) {
            numOfNodes++;
            cur = cur.next;
        }
        int idx = (numOfNodes - (n)) ;
        cur = head;
        ListNode prev = null;
        while(idx > 0) {
            prev = cur;
            cur = cur.next;
            idx--;
        }
        if(prev == null) {
        	return head.next;
        }
        prev.next = cur.next;
        return head;
    }
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		removeNthFromEnd(node,5);

	}

}
