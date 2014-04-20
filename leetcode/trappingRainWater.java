/*
leetcode: 

Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


*/


/*get the thought from other's answers, 
对于每个柱子,找到其左右两边最高的柱子,该柱子能容纳的面积就是 min(max_left, max_right) - height。所以,
1. 从左往右扫描一遍,对于每个柱子,求取左边最大值;
2. 从右往左扫描一遍,对于每个柱子,求最大右值; 
3. 再扫描一遍,把每个柱子的面积并累加。
*/


//the following are my codes: 


import java.util.Hashtable; 
public class Solution {
    public int trap(int[] A) {
        
        int result =0; 
        if(A.length<=2)
            return result; 
        //make a hashtable to install the corresponding maxLeft/maxRight for each index, except the 0 and the last index
        
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        //find the maxLeft for each index
        int maxLeft=A[0];
        for(int i =1; i< A.length-1; i++){
            table.put(i,maxLeft);
            if(A[i]>maxLeft){
                maxLeft = A[i];
            }
        }
        
        //find the maxRight for each index
        int maxRight = A[A.length-1];
        for(int i=A.length-2; i>=1; i--){
            int temp = table.get(i);  //find the corresponding maxLeft;
            if(temp>maxRight){   //get the Min(maxLeft, maxRight)
                table.put(i,maxRight);
            }
            if(A[i]>maxRight){
                maxRight=A[i];
            }
        }
        
        //get the Min(maxLeft, maxRight)- height
       for(int i =1; i<A.length-1;i++){
           int temp = table. get(i);
           if(temp- A[i]>0){   //if min(maxLeft, maxRight)>height
                result += temp-A[i];
           }
       }
       return result;
        
    }
}

