package com.neetcode;

import com.neetcode.MergeSortedLinkedLists.ListNode;

public class ReOrderList {

	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			next = null;
		}
	}

	public static ListNode reverseLinkedList(ListNode node) {

		ListNode prev = null;
		ListNode cur = node;
		ListNode next = null;

		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;

	}

	public static ListNode reArrangeListNode(ListNode node) {
		ListNode fast = node;
		ListNode mid = node;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			mid = mid.next;
		}

		ListNode secondPart = reverseLinkedList(mid.next);
		ListNode cur = node;
		while (cur != null && secondPart != null) {
			ListNode temp = secondPart.next;
			ListNode temp1 = cur.next;
			cur.next = secondPart;
			secondPart.next = temp1;
			cur = temp1;
			secondPart = temp;

		}
		if(secondPart ==null) {
			mid.next = null;
		}
		return node;

	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
//		ListNode node4 = new ListNode(5);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
//		node3.next = node4;

		reArrangeListNode(node);

	}

}
