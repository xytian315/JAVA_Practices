/*
leetcode
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class Solution{
	public int singleNumber(int[] A){
		//check input
		if(A== null || A.length ==0)
			return -1;
		int result = A[0];
		for(int i =1;i< A.length;i++)
			result = result ^ A[i];
		return result;
	}

}
