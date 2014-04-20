/*

leetcode: 
Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

*/
//mycodes: dynamic programming 



public class Solution {
    public int climbStairs(int n) {
       
      int[] map = new int[n+1];
      for(int i=1;i<map.length;i++)
        map[i]=-1;
      return climbStairs(n,map);
    }
    private int climbStairs(int n, int[] map){
        if(n<0)
            return 0;
        else if(n<=1)
            return 1;
        else if(map[n]>-1)
            return map[n];
        return map[n]=climbStairs(n-2,map)+climbStairs(n-1,map);
    }
    
}
