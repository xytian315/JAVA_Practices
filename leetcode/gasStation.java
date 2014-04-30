/*
Gas Station 

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/


//O(N ) 的解法是,设置两个变量,sum 判断当前的指针的有效性;total 则判断整个数组是否有 解,有就返回通过 sum 得到的下标,没有则返回 -1。

public class Solution {

	public int canCompleteCircuit(int[] gas, int[] cost){
	
		
	int sum =0;
	int j=-1;
	int total=0;
	//use sum to check whether gas[i]+remainder> cost[i]
	//use j to check where is the pointer;
	//use total to check if there is a solution to this question. 
	
	for(int i =0; i< gas.length; i++){
		sum+=gas[i]-cost[i];
		total +=gas[i]-cost[i];
		
		if(sum<0){
			j=i;
			sum =0; //go on to check the next index
		}
	}
	
	return total>= 0? j+1:-1;
	}
}




//my code: O(N2) complexity, not good
public class Solution{

	public int canCompleteCircuit(int[] gas, int[] cost){
	
		for(int i =0; i< gas.length; i++){
			int remainder =0;
			
			int j;
			for(j=i; j< gas.length; j++){
				if(remainder + gas[i] <cost[i])
					break;
				else 
					remainder = remainder+gas[i]-cost[i];
			}	
			
			if( j!= gas.length-1)
				continue; 
			
			int k;
			for(k = 0; k< i; k++){
				if(remainder + gas[i]< cost[i])
					break;
				else
					remainder = remainder+gas[i]-cost[i];
			}
			if(k!= i-1)
				continue;
			else
				return i;
			
		}
			return -1;
	
	}

}
