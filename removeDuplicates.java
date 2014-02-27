/*
Remove duplicates from an unsorted linkedList
*/

public class Solution{
    public static LinkedListNode removeDuplicates(LinkedListNode head){

    	LinkedListNode current = head;
    	LinkedListNode previous = null;
    	//make a new HashTable to decide whether there is duplicate
    	HashTable table = new HashTable();

    	while(current!= null){
    		if(!table.containsKey(current.data)){
    			table.put(current.data, true);
    			previous = current;
    		}else{
    			previous.next = current.next;
    		}
    		current= current.next;

    	}

    	return head;

    }

    //if we don't allow a buffer, it will be quardratic time o(n2)


    public static LinkedListNode removeDuplicates2(LinkedListNode head){
    	LinkedListNode current = head;
    
    	while(current!= null){
    		LinkedListNode runner = current;
    		while(runner.next ! = null){
    			if(runner.next.data == current.data){
    				runner.next = runner.next.next;
    			}else{
    				runner = runner.next;
    			}
    		}
    		current = current.next;
    	}
    	return head;

    }


}
