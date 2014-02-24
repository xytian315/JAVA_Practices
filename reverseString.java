/*
Write a function to reverse an array of characters in place.
"In place" means "without creating a new string in memory."

In general, an "in place" algorithm will require swapping elements.
*/
public class Solution{
	public static char[] reverseString(char[] chars){
		int i =0;
		int j=chars.length-1;
		while(i<j){
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
			i++;
			j--;
		}
		return chars;
	}

}
