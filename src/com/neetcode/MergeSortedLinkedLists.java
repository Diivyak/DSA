package com.neetcode;

public class MergeSortedLinkedLists {

	public static class ListNode{
		int val;
		ListNode next;
		
		public  ListNode(int val) {
			this.val= val;
			next = null;
		}
	}
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = null;
        ListNode prev = null;
        while(list1 != null && list2 != null) {
        	
        	if(list1.val <= list2.val ) {
        		if(ans == null) ans = list1;
        		prev = list1;
        		while(list1 != null) {
        			if(list1.val > list2.val)  break;
        			prev = list1;
        			list1 = list1.next;
        			
        		}
        		prev.next = list2;
        	}else {
        		if(ans == null) ans = list2;
        		prev = list2;
        		while(list2 != null) {
        			if(list2.val > list1.val)  break;
        			prev = list2;
        			list2 = list2.next;
        			
        		}
        		prev.next = list1;
        	}
        }
        return ans;
    }
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		

	}

}
