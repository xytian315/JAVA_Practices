/*
leetcode
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = “leetcode”,
dict = ["leet", "code"].

Return true because “leetcode” can be segmented as “leet code”.


*/

//recursive 
//Time: O(2^n)
public class Solution {
	public boolean wordBreak(String s, Set<String> dict){
		
		return wordBreakHelper(s,dict,0);
	
	}
	
	
	private boolean wordBreakHelper(String s, Set<String> dict, int start){
		//base case
		if(start == s.length())
			return true;
			
		
		for(String a: dict){
		
			int end = a.length() + start;
			
			if(end> s.length())
				continue;
			
			if(s.substring(start, end).equals(a))
				if(wordBreakHelper(s,dict,end))
					return true;
		
		}
		
		return false;
	
	
	}


}


//Dynamic programming
//O(string length * dict size)

public class Solution{

	public boolean wordBreak(String s, Set<String> dict){
		
		//checker[i] --- 0-i-1
		boolean[] checker = new boolean[s.length()+1];
		checker[0] = true;
		
		for(int i =0; i<s.length();i++){
			if(!checker[i])
				continue;
				
			for(String a: dict){
				int end = a.length()+i;
				
				if(end> s.length())
					continue;
					
				if(checker[end])
					continue;
				
				if(s.substring(i,end).equals(a))
					checker[end]= true;
			
			}
		
		}
		
		return checker[s.length()];
	
	
	}
}
