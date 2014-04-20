/*

leetcode: 
Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

*/

/*
设 f (n) 表示爬 n 阶楼梯的不同方法数,为了爬到第 n 阶楼梯,有两个选择: 
• 从第n−1阶前进1步;
• 从第n−2阶前进2步;
有 f(n) = f(n − 1) + f(n − 2)。 这是一个斐波那契数列。
递归,太慢
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
