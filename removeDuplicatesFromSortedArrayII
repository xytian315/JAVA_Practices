/*
leetcode: Remove Duplicates from Sorted Array II

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].

*/
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length <=2)
            return A.length;
        int index =2;
        for(int i =2; i< A.length; i++){
            if(A[i]!=A[index-2]){
                A[index] = A[i];
                index++;
            }
        }

        return index;
    }
}

/*
note: 
because it is sorted array, we can just use one temp variable to resovle this problem.
if it is not, we need to use a hashmap to count the number of duplicate elements.

the question is allowed at most twice, so we just need to compare the current elment with the previous two element. 
the new array starts from the position index 2. 

don't forget to check if the input array's length is less than 2 elements.
*/
