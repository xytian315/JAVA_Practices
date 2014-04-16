/*
leetcode: 3Sum 

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

*/


public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        //result
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        //check input
        if(num.length< 3)
            return result;
        
        //sort the array
        Arrays.sort(num);
        
        for(int i =0; i< num.length-2; i++){
            //check the duplicates remove the duplicate case
            if(i==0 || num[i] > num[i-1]){
                int negative = -num[i];
                int start = i+1;
                int end = num.length-1;
                
                while(start< end){
                    if(num[start]+num[end] == negative){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        
                        temp.add(num[i]);
                        temp.add(num[start]);
                        temp.add(num[end]);
                        
                        result.add(temp);
                        //don't forget to more start and end pointer!!!!!!!!
                        start++;
                        end--;
                        //remove the duplicate case
                        while(start<end && num[start]== num[start-1]){
                            start++;
                        }
                        while(start< end && num[end] == num[end+1]){
                            end--;
                        }
                    }else if(num[start]+num[end] < negative){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return result;
    }
}



/*
note : 

先排序,然后左右夹逼,复杂度 O(n2)。
这个方法可以推广到 k-sum,先排序,然后做 k − 2 次循环,在最内层循环左右夹逼,时间复杂 度是 O(max{n log n, nk−1 })。


don't forget to check the duplicates!!!!!

and don't forget to more the start and end pointer when found the match result, since there might be other match results. 

*/
