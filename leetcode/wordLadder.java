/*

leetcode

word Ladder

Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

*/


//it is the shortest path problem

//use bread first search of depth first search 
// bread first search queue
//depth first search stack

//uses two queues to track the word and distance

public class Solution {

	public int ladderLength(String start, String end, HashSet<String> dict){
	
		//check the input
		if(dict.size()==0)
			return 0;
	
		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
		
		
		wordQueue.add(start);
		distanceQueue.add(1);
		
		//add the end word into dictionary
	    dict.add(end);
	    
	    
	    while(!wordQueue.isEmpty()){
	    	
	    	String currentWord = wordQueue.pop();
	    	int currentDistance = distanceQueue.pop();
	    	
	    	if(currentWord.equals(end))
	    		return currentDistance;
	    		
	   
	    	for(int i =0; i< currentWord.length();i++){
	    	
	    	 	char[] currentCharArray = currentWord.toCharArray();
	    	
	    		for(char c = 'a'; c <= 'z'; c++){
	    		
	    			currentCharArray[i] = c;
	    			
	    		 	String newWord = new String(currentCharArray);
	    		 	
	    		 	if(dict.contains(newWord)){
	    		 		wordQueue.add(newWord);
	    		 		distanceQueue.add(currentDistance +1);
	    		 		dict.remove(newWord);
	    		 	
	    		 	}	    		
	    		}
	    	
	    	
	    	}
	    
	    }	
		return 0;
	}


}
