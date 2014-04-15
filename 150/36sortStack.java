/*
3.6 Write a program to sort a stack in ascending order 
(biggest item on top)
Use at most one additional stack to hold items

follwoing solution is O(n2) time, O(n)space,
if allowing two addtional stacks, we can use merge sort or quick sort

*/


public class Solution{

	public Statck<Integer> sortStack(Stack<Integer> s){

		Stack<Integer> r = new Stack<Integer>();

		while(!s.isEmpty()){

			int tmp = s.pop();
			while(!r.isEmpty()&& r.peek() > tmp){
				s.push(r.pop());
			}

			r.push(tmp);
		}
		return r;
	}

}
