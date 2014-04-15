/*
2.4 write code to partition a linked list around a value x, such that all nodes
less than x come before all nodes greater than or equal to x. 
*/

public class Solution{
    public static LinkedListNode partitionLinkeList(LinkedListNode head, int v){
    	if(head == null)
    		return null;

    	LinkedListNode beforeStart = null;
    	LinkedListNode afterStart= null;
    	// head!=null
    	while(head!=null){
    		//the most important part : put next into temp, since it is going to change later
    		LinkedListNode next = head.next;
    		if(head.data < v){
    			//put it before the beforeStart Node;
    			head.next = beforeStart;
    			beforeStart = head;

    		}else{
    			head.next = afterStart;
    			afterStart = head;
    		}
    		head = next;  //let the head equals temp next node
    	}

    	if(beforeStart == null)
    		return afterStart;

    	LinkedListNode result = beforeStart;
    	while(beforeStart.next!= null){
    		beforeStart = beforeStart.next;
    	}
    	//merger the two parts together
    	beforeStart.next = afterStart;

    	return result;

}
