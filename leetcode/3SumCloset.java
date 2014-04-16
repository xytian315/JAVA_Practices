/*
leetcode: 

3Sum Closest

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
For example, given array S = {-1 2 1 -4}, and target = 1. Thesumthatisclosesttothetargetis2. (-1+2+1=2).

*/

/*
thought: first sort the array, 

and then iterate the sorted array, make two pointers start and end(of the array), compare the sum with the target, move the pointers based on different situation. 

the following code is more readable after I search the answer
*/
public class Solution {
    public int threeSumClosest(int[] num, int target) {
       
       int result = 0;
       int diff = Integer.MAX_VALUE;
       
       Arrays.sort(num);
       
       for(int i=0; i< num.length-2; i++){
           int start = i+1;
           int end = num.length -1;
        
           while(start<end){
               int sum = num[i]+num[start]+num[end];
               
               int temp = Math.abs(sum-target);
               if(temp < diff){
                   diff = temp;
                   result = sum;
               }
               
               if( sum== target)
                    return target;
                else if(sum < target)
                    start++;
                else 
                    end--;
           }
       }
       return result;
    }
}




//the first time I didn't see the answer to get it right, needs to be remember! azaaza fighting!
//the following are my codes: I need to make a sum variable to make the code more readable and more effcient. 
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        
        int result =0; 
        
        int diff =Integer.MAX_VALUE;
        
        Arrays.sort(num);
        
        for(int i=0; i< num.length-2; i++){
            
            int offset = target -num[i];
            
            int start = i+1;
            int end = num.length -1;
            
            while(start < end){
                if(num[start]+num[end] == offset){
                    return target;
                }else if(num[start]+num[end] < offset){
                    
                    int temp= Math.abs(num[start]+num[end]+num[i]-target);
                    if(temp < diff){
                        result = num[start]+num[end]+num[i];
                        diff= Math.abs(num[start]+num[end]+num[i]-target);
                    }
                    start++;
                        
                }else{
                   
                    int temp= Math.abs(num[start]+num[end]+num[i]-target);
                    if(temp < diff){
                        result = num[start]+num[end]+num[i];
                        diff= Math.abs(num[start]+num[end]+num[i]-target);
                    }
                     end--;
                }
            }
        }
        return result; 
        
    }
}
