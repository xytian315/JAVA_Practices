/*
3.2 Design a stack which, in addition to push and pop, also has a function 
min which returns the minimum element?push, pop, and min should all operate in O(1) time

implement min heap 

hint: use another stack to track min value


*/

public class StackMin{

	private Stack<Integer> minStack;
	private Stack<Integer> primaryStack;

	public StackMin(){

		minStack = new Stack<Integer>();
		primaryStack = new Stack<Integer>();
	}

	public void push(int value){
		if(value < findMin()){
			minStack.push(value);
		}
			primaryStack.push(value);

	}

	public int pop(){
		int result = primaryStack.pop();

		if(result == findMin(){
			minStack.pop();
		}

		return result;
	}


	public int findMin(){
		if(minStack.isEmpty()){
			return Integer.MAX_VALUE;
		}

		return minStack.peek();
	}

	public int size() {
		return primaryStack.size();
	}
	


}
