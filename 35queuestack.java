/*
3.5 implement a MyQueue class which implements a queue using two stacks
*/

//don't forget to write size() method

public class MyQueue {
	Stack<E> firstStack;
	Stack<E> secondStack;

	public Myqueue(){
		firstStack = new Stack<E>();
		secondStack = new Stack<E>();
	}

	public void add(E value){

		secondStack.push(value);
	}

	public E remove(){
		shiftHelper();
		return secondStack.pop();
	}

	public E peek(){
		shiftHelper();
		return secondStack.peek();
	}

	private shiftHelper(){
		if(secondStack.isEmpty()){
			while(!firstStack.isEmpty()){
				E temp = firstStack.pop();
				secondStack.push(temp);
			}
		}
	}


	public int size(){
		return firstStack.size()+secondStack.size();
	}

}
