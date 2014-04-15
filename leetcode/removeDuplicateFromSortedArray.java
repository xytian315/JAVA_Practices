/*
leetcode: remove duplicates from sorted array

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].

*/

/*

time: O(N), space O(1)


in place removing elements in array, thinking there are two arrays, the returned array will use the space of 
the original array, the returned array starts from 0 position, use one temp variable to record the position,
the original array starts from 1 position

since the orginal array looping from 1 position, at least there is one element in the array, so we need to check
if the input array is empty or not. 

*/



public class Solution {
    public int removeDuplicates(int[] A) {
        //dont'f forget to check there is no element in the array, A.length<1 
        
        if(A.length == 0)
            return 0;
        
        int index =0;
        
        for(int i =1; i<A.length;i++){
            if(A[index] != A[i]){
                index++;
                A[index] = A[i];
            }
        }
        
        return index +1;
    }
}
