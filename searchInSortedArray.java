/*
leetcode: Search in sorted array:

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int search(int[] A, int target) {
        if(A.length ==0)
            return -1;
        return search(A,target,0,A.length-1);
    }
    
    public int search(int[] A,int target, int start, int end){
                
        //never forget the base case when recursive!!!!!!!
        if(start>end)
            return -1;
            
       
        int mid = (start+end)/2;
    
        
        if(target == A[mid])
            return mid;
       
            
        if(A[start]<= A[mid]){
            if(target >= A[start] && target< A[mid])
                return search(A,target, start, mid-1);
            else 
                return search(A,target,mid+1, end);
        }
        if(A[mid]<= A[end]){
            if(target> A[mid] && target<= A[end])
                return search(A,target,mid+1, end);
            else
                return search(A,target,start, mid-1);
        }
        return -1;
        
    }
}


/*
note:

the first mistake: forget the basecase: start <end
the second mistake: target should be greater than start and less than mid or greater than mid less than end, need to compare both ranges. 
*/
