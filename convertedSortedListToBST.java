/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

bottom up approach!!!!!! use linked list next pointer to point to the right position

first mistake: don't forget to construct a new pointer when you want to change the linkeList Node 

second mistake: change the pointer is not equal to changing the value, don't forget to change the value;
*/

public class Solution{
	
	static ListNode current;
	public TreeNode sortedListToBST(ListNode head){
		if(head == null)
			return null;
		current = head;
		ListNode h = head;
		int length = findLength(h);
		return sortedListToBST(0,length-1);
	}
	
	TreeNode sortedListToBST(int start, int end){
		//base case
		if(start > end)
			return null;
		int mid = (start +end)/2;
		TreeNode left = sortedListToBST(start,mid-1);

		TreeNode root = new TreeNode(current.val);
		root.left = left;
		
            	current= current.next;
        	
		TreeNode right = sortedListToBST(mid+1,end);
		root.right = right;
		return root;
	
	}

	int findLength(ListNode h){
		int length =0;
		while(h !=null){
			h = h.next;
			length++;
		}
		return length;
	}
}

public class Solution{
	public TreeNode sortedListToBST(ListNode head){
		if(head == null)
			return null;
		ListNode h = head;
		int length = findLength(h);
		return sortedListToBST(head,0,length-1);
	}
	
	TreeNode sortedListToBST(ListNode head,int start, int end){
		//base case
		if(start > end)
			return null;
		int mid = (start +end)/2;
		TreeNode left = sortedListToBST(head,start,mid-1);

		TreeNode root = new TreeNode(head.val);
		root.left = left;
		if(head.next != null){
           		 head.val = head.next.val;
            		head.next = head.next.next;
        	}

		
		
		TreeNode right = sortedListToBST(head,mid+1,end);
		root.right = right;
		return root;
	
	}

	int findLength(ListNode h){
		int length =0;
		while(h !=null){
			h = h.next;
			length++;
		}
		return length;
	}
}
