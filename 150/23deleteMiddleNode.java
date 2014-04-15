/*
2.3Implement an algorithm to delete a node in the middle of a singly linked list
given only access to that node
*/

public class Solution{
    public static boolean deleteMiddleNode(LinkedListNode node){

    	//check input!!!! node.next!=null
    	if(node == null || node.next == null)
    		return false;

    	node.data = node.next.data;
    	node.next = node.next.next;
    	return true;

}
