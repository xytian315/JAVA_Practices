/*

Reverse a linked list, recursive

*/

public class Solution(){
	
	public static LinkedListNode reverseLinkedList(LinkedListNode node){

		//base case, no node
		if(node == null) 
			return null;
		//one node
		if(node.next == null)
			return node;
		//more than two nodes
		LinkedListNode second = node.next;

		//need to unlink the node or there is a cycle; 
		node.next = null;

		LinkedListNode rest = reverse(second);

		second.next = node;

		return rest; 
	}

}
