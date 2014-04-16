/*
leetcode: 
4 sum
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
Note:
• Elements in a quadruplet (a, b, c, d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d) • Thesolutionsetmustnotcontainduplicatequadruplets.
For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
A solution set is:
  (-1,  0, 0, 1)
  (-2, -1, 1, 2)
  (-2,  0, 0, 2)

*/


import java.util.HashSet;

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        
        if(num.length< 4)
            return result; 
            
        Arrays.sort(num);
        
        for(int i =0; i< num.length-3; i++){
             for(int j=i+1; j<num.length-2;j++){
              
                        
                        int start = j+1;
                        int end = num.length-1;
                        
                        while(start<end){
                            int sum = num[i]+num[j]+num[start]+num[end];
                            
                            if(sum == target){
                                ArrayList<Integer> temp = new ArrayList<Integer>();
                                temp.add(num[i]);
                                temp.add(num[j]);
                                temp.add(num[start]);
                                temp.add(num[end]);
                                
                                if(!set.contains(temp)){
                                    set.add(temp);
                                    result.add(temp);
                                }
                                
                                start++;
                                end--;
                                
                            }else if(sum<target)
                                start++;
                            else
                                end--;
                        }
                }
        }
       
        
        return result; 
    }
}


/*
can use a HashSet to remove duplicates!!!! 


// 先排序,然后左右夹逼,时间复杂度 O(n^3),空间复杂度 O(1)

*/
