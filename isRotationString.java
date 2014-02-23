/*
Given two string, write a function to check if one string is a rotation of the other

*/
public class Solution{
	public static boolean isRotation(String a,String b){
		return (a.length()==b.length() && (a+a).indexOf(b)!= -1);
	}

}
