/*
Given two strings, write a method to decide if one is a permutaion of the other

palindrom = anagram

possible solution: 1.sort 2. construct array[256] 3. iterate the two strings??

*/

public class solution {

	public static boolean isPermutation(String a, String b){
		if(a.length()!=b.length())
			return false;
		return sort(a).equals(sort(b));  //two string compare
	}

	private string sort(String s){
		char[] chars= s.toCharArray();
		Arrays.sort(chars); 
		//construct a string from char array
		return new String(chars);
	}

}

public class Solution2{
	public static boolean isPermutation2(String a, String b){
		if(a.length()!=b.length())
			return false;

		int[] checker = new int[256];

		for(int i =0; i< a.length(); i++){
			checker[(int)a.charAt(i)]++;
		}

		for(int i=0; i< b.length(); i++){
			checker[(int)b.charAt(i)]--;
			if(checker[(int)b.charAt(i)]<0)
				return false;
		}
		return true;

	}

}


public class Solution3 {
	public static boolean isPermutation3(String a, String b){
		if(a.length()!= b.length())
			return false;
		// for(int i =0 ; i< a.length()/2;i++){
		// 	if(a.charAt(i)!=b.charAt(b.length-1-i))
		// 		return false;
		// }
		// return true;
		int i=0;
		int j= a.length -1
		while(i<j){
			if(a.charAt(i)!=b.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
