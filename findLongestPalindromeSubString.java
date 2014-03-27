/*
Finding the longest palindromic substring

*/

public class Solution {
    public String findLongestPalin(String str){
    	if(str.isEmpty())
    		return null;
    	if(str.length == 1)
    		return str;

    	String result = str.subString(0,1);

    	for(int i =0; i<str.length()；i++){

    		String temp = palindHelper(str, i, i);

    		if(temp.length() > result.length())
    			result = temp;

    		temp = palinHelper(str, i , i+1);

    		if(temp.length()> result.length())
    			result = temp;


    	}

    	return result;



    }

    private String palindHelper(String str, int start, int end){
    	while(start>=0 && end <= str.length()-1 && str.charAt(start) == str.charAt(end)){
    		start--;
    		end++;
    	}
    	return str.subString(start+1, end);

    }
      
}
