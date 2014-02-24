/*
reverse words of a string
*/

public class Solution{
	public static void char[] reverseWords(char[] chars){
		reverseWordsHelper(chars,0, chars.length-1);
		int start=0;
		int preStartSpace=0;
		for(int i =0 ; i< chars.length; i++){
			if(chars[i]== ' ')
				startSpace=prevStartsSpace;
				int end =i;
				reverse(chars,start,end);
				preStartSpace=i+1;
		}
		return chars;

	}

	private void reverseWordsHelper(char[], int start, int end){
		while(start<end){
			char temp = char[start];
			char[start] = char[end];
			char[end] = temp;
			start++;
			end--;
		}
	}
}
