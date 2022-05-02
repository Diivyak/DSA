package com.neetcode;

public class AddTwoNumbers {

	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode node = new ListNode(0);
        ListNode cur = node;
        int carry = 0; 
        while(l1 != null || l2 != null || (carry > 0)) {
            
            if(l1 !=null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 !=null) {
                carry += l2.val;
                l2 = l2.next;
            }
            
            if(carry >= 10) {
                cur.next = new ListNode(carry%10);
                carry = 1;
            }else{
                cur.next = new ListNode(carry);
                carry = 0;
            }
            cur = cur.next;
        }
        return node.next;
    }
	public static void main(String[] args) {
		ListNode node = new ListNode(9);
		ListNode node1 = new ListNode(9);
		ListNode node2 = new ListNode(9);
		ListNode node3 = new ListNode(9);
		ListNode node4 = new ListNode(9);
		ListNode node5 = new ListNode(9);
		ListNode node6 = new ListNode(9);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		ListNode node7 = new ListNode(9);
		ListNode node8 = new ListNode(9);
		ListNode node9 = new ListNode(9);
		ListNode node10 = new ListNode(9);
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		addTwoNumbers(node, node7);
		
//		[2,4,3]
//		[5,6,4]

	}

}
