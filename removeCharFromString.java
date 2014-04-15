/*
Write a method which will remove any given character from a String?

*/
public class Solution{
	public static String removeCharFromString(String s, char c){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i< s.length();i++){
			if(s.charAt(i) == c)
				continue;
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

}
