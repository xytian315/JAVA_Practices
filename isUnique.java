/* if a string has all unique characters 
*/


/*
do not use additional data structure
ask whether the string is ASCII or Unicode
remember if the string is greater than 256, then automatically return false
*/

public class solution{
	public static boolean isUnique(String s){
		if(s.isEmpty() || s.length > 256)
			return false;
		boolean checker[] = new boolean[256];
		for(int i =0; i< s.length(); i++){
			int temp = s.charAt(i);
			if(checker[temp])
				return false;
			checker[temp]=true;
		}
		return true;
	}

}
/*
this solution use HashSet additional data structure
*/
public class Solution{
	public static bollean isUnique2(String s){
		if(s.isEmpty())
			return false;
		HashSet<Character> map = new HashSet<char>();
		char[] chars = s.toCharArray();
		for(int i =0 ; i< chars.length; i++){
			if(map.contains(chars[i]))
				return false;
			else{
				map.add(chars[i]);
			}
		}
		return true;
	}

}


