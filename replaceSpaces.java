/*
Write a method to replace all spaces in a string with '%20'. 
you may assume that the string has sufficient space at the end of the string to 
hold the additional characters and that you are given the true length of the string


I first use StringBuilder to answer this question but the question wants us to manipulate
the char array 
*/


public class Solution{
	public static void replaceSpace(String s, int length){
		int count =0;
		char[] chars= s.toCharArray();
		for(int i=0; i < length; i++){
			if(chars[i]= " ")
				count++;
		}

		int newLength=length+2*count;

		//mark the end?
		chars[newLength]='\0';
		
		for(int i = length-1; i>=0;i--){
			if(chars[i]== ' '){
				chars[newLength-1]='%';
				chars[newLength-2]='2';
				chars[newLength-3]='0';
				newLength = newLength-3;
			}
			chars[newLength-1]=chars[i];
			newLength--;
		}
		

}
