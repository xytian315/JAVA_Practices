/*

9.1 A child is running up a staircase with n steps, and can hop either 1 step,2 steps, or 3 steps at a time. 
Implement a method to count how many possible ways the child can run up the stairs.

*/

//recursive

public int countWays(int n){
	if(n < 0)
		return n;
		
	else if(n == 0)
		return 1;
	else 
		return countWays(n-1)+countWays(n-2)+countWays(n-3);


}

//dynamic programming

public int countWays(int n, int[] map){
	if(n<0)
		return 0;
		
	else if(n == 0)
		return 1;
	else if(map[n] >-1)
		return map[n];
	else 
		return map[n] = countWays(n-1, map) + countWays(n-2, map) + countWays(n-3, map);
	


}
