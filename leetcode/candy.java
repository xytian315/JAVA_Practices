/*
Candy: 

There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements: • Eachchildmusthaveatleastonecandy.
• Childrenwithahigherratinggetmorecandiesthantheirneighbors.
What is the minimum candies you must give?

*/

// 时间复杂度 O(n),空间复杂度 O(n)
//左右各扫描一遍
public class Solution{

	public int candy(int[] ratings){
		int result =0;
		int candy[] =new int[ratings.length];
		candy[0]=1;
		for(int i =1; i< candy.length; i++){
			if(ratings[i]> ratings[i-1]){
				candy[i]=candy[i-1]+1;			
			}else
				candy[i]=1;		
		}	
		
		for(int j = candy.length-2; j>=0; j--){
		
			if(ratings[j] > ratings[j+1]){
				candy[j]=Math.max(candy[j+1]+1,candy[j]); // do not forget to use Math.max condition!!!!! to check if it is already greater
			}
			
		}
		
		for(int i =0; i< candy.length;i++){
			result += candy[i];
		}
		
		return result; 
	}
}
