/*
leetcode: Search in Rotated Sorted Array II
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.


*/

public class Solution {
    public boolean search(int[] A, int target) {
        if(A.length ==0)
            return false;
        return search(A,target,0,A.length-1);
    }
    
    public boolean search(int[] A, int target, int start, int end){
        if(start > end)
            return false;
            
        int mid = (start +end)/2;
        
        if(target == A[mid])
            return true;
        
        if(A[start]< A[mid]){
            if(target>=A[start] && target <A[mid])
                return search(A, target, start, mid-1);
            else
                return search(A, target, mid+1, end);
        }
        
        else if(A[start]> A[mid]){
            if(target >A[mid] && target <= A[end])
                return search(A, target, mid+1, end);
            else
                return search(A, target, start, mid-1);
        }
        
        else if(A[start] == A[mid]){
            
            if(A[mid]!= A[end])
                return search(A,target,mid+1, end);
            
            else{
            
                boolean result = search(A, target, start, mid-1);
                
                if(result)
                    return true;
                else{
                    return search(A, target, mid+1, end);
                }
            
            }
        }
        
        return false;
        
    }
    
}


/*
note:
时间复杂度 O(n),空间复杂度 O(1)
when write the array.length -1, always remember to check the input.

The first mistake: we need to think about the three cases of start and mid relationships, > = < , when > means that we need to check the other half. not explicitly, to see the other half mid < end, it will miss the case mid = end 
*/
