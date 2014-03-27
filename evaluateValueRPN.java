/*
Leetcode
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

*/

public class Solution {
    public int evalRPN(String[] tokens) {
        	int result =0;

		Stack<Integer> s = new Stack<Integer>();

		String operations = "+-*/";

		for(String st : tokens){
			if(!operations.contains(st))
				s.push(Integer.valueOf(st));
			else{
				int first = s.pop();
				int second = s.pop();

				if(st.equals("+"))
					s.push(first+second);
				else if(st.equals("-"))
					s.push(second-first);
				else if(st.equals("*"))
					s.push(first*second);
				else 
					s.push(second/first);

			}

		}

		return s.pop();

    }
}
