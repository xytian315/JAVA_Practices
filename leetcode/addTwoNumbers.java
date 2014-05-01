/*
Leetcode:

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode current = null;
        ListNode head = null;
        int n=0;
        int data=0;
        while(l1!=null || l2 !=null){
            if(l1!=null && l2!=null){
                data = (l1.val+l2.val+n)%10;
                n=(l1.val+l2.val+n)/10;
            }
            else if(l2== null){
                data = (l1.val+n)%10;
                n = (l1.val+n)/10;   
            }
            else if(l1 == null){
                data =(l2.val+n)%10;
                n = (l2.val+n)/10;
            }
            
            ListNode temp = new ListNode(data);   
            
            if(current == null){
                current = temp;
                 head = current; //the mistake I made at this line of code! I put this line of code during initialzation, ListNode head = current; it is not right! ????
            }else{
                current.next = temp;
                current = temp;
            }
            
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next; //don't forget to move the pointer
        }
            if(n>0){
                ListNode temp = new ListNode(n);
                current.next = temp;
            }
        
        return head;
        
    }
}
