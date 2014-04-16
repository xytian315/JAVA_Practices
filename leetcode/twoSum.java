/*
leetcode: 

Two Sum
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

*/

import java.util.Hashtable;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int result[] = new int[2];
        
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        
        for(int i=0; i<numbers.length;i++){
            if(table.containsKey(numbers[i])){
                result[0] = table.get(numbers[i])+1;
                result[1] =i+1;
            }else
                table.put(target-numbers[i],i);
        }
         return result; 
    }
}
/*
note: the mistake I made, hashtable's key must be unique, I made the key as the numbers[i], but the array would possibly have duplicate values. 

just use one loop could resolve this problem, put all the offset value into the Hashtable, and check if the offset is in the Hashtable,

the second mistake I made, check the keys need to be numbers[i](the current value), and put the key(key is the offset value of the current element, target-numbers[i], value is the index)

*/

