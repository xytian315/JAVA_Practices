/*

Implement a routine that prints all possible orderings of the characters in a string. 
In other words, print all permutations that use all the characters from the original string. 

exposed(P115)
Recursive
*/

public class Permutations() {

	private final String in;
	private StringBuilder out = new StringBuilder();
	private boolean[] used;
	
	public permutations(String str){
		in = str;
		used[] = new boolean[str.length()];
	}
	
	public void permutate(){
		
		if(out.length() == in.length()){
			System.out.print(out);
			return;
		}
		for(int i=0; i< in.length(); i++){
		
			if(used[i]) 
				continue;
			out.append(in.charAt(i));
			used[i] = true;
			
			permutate();
		
			used[i] = false;
			
			out.setLength(out.length()-1);
		}
		
	}

}
