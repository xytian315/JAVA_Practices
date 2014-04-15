
/*
Cracking coding interview 
2.6 Given a circular linked list, 
implement an algorithm which returns the node at the beginning of the node

anther question: if the linked list has a loop 

resolved way: has two pointers slow and fast runns as the speed of 1 or 2

they will collide if there is a loop, at the point "LoopSize - K" steps(k is the start of the loop node)

let one pointer points to the head again, they will collide at the start of the loop node
since both of them needs K steps to arrive there

*/

LinkedListNode returnBegin(LinkedListNode head){

	//make two pointers, slow and fast
	LinkedListNode slow = head;
	LinkedListNode fast = head;

	//let fast runs as the speed 2, slow runs as the speed of 1
	//if there is a loop, they will collide, stop when they collide
	while(fast.next != null && fast != null){
		fast = fast.next.next;
		slow = slow.next;

		if(slow == fast)
			break;
	}

	//check the error when there is no loop
	if(fast == null || fast.next == null)
		return null;

	//let slow points the head
	slow = head;

	//slow and fast will collide at the start of the loop
	while( fast != slow){
		fast = fast.next;
		slow = slow.next;
	}

	return fast;
}
