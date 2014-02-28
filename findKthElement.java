/*
Implement an algorithm to find the kth to last element of a singly linked list
*/

public class Solution{
    public static LinkedListNode findKthElement(LinkedListNode head, int k){

    	//check null
    	if(k<=0)
    		return null;

    	LinkedListNode first = head;
    	LinkedListNode second = head;

    	// remember it is k-1 times!!!!
    	for(int i =0; i< k-1; i++){
    		//check null
    		if(first == null)
    			return null;
    		first = first.next;
    	}

    	//check null again!!! don't forget
    	if(first == null) 
    		return null;

    	while(first.next ! = null){
    		first = first.next;
    		second = second.next;
    	}

    	return second;

    }

   


}
