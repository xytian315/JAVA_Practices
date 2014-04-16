/*

Remove Element

Given an array and a value, remove all instances of that value in place and return the new length. 
The order of elements can be changed. It doesn’t matter what you leave beyond the new length.
*/

public class Solution {
    public int removeElement(int[] A, int elem) {
        int count =0;
        
        for(int i =0; i< A.length; i++){
            if(A[i]!=elem)
                A[count++] = A[i];
        }
        return count;
    }
}

//only take me 1 minute to resolve this questions, haha

