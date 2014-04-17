/*

Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permu- tation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascend- ing order).
The replacement must be in-place, do not allocate extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
  1,2,3 → 1,3,2
  3,2,1 → 1,2,3
  1,1,5 → 1,5,1
*/


/*
algorithm: 

1. from right to left, find the first element(partition number) which is not greater than previous one
/violates the acceding order
2. from right to left, find the first element(change number) which is greater than the partition number
3. swap the partition number and change number
4. reverse all the digits on the right of the partition index. 

*/

public class Solution {
    public void nextPermutation(int[] num) {
        
        //check the input
        if(num.length<=1)
            return;
        
        int partitionIndex =-1;
      	int partitionNum =0;
      	
      	//find the partition number  
        int previous =num[num.length-1]; 
        for(int i=num.length-2; i>=0;i--){
    		if(num[i]< previous){
    		    partitionNum = num[i];
    			partitionIndex = i;
    			break;
    		}
    		previous = num[i];
      	}  
      	
      	//if there is no partition number
      	if(partitionIndex == -1){
      	    swap(num, 0, num.length-1);
      	    return;
      	}
      	
      	//find the change number
      	//then swap the change number and partition number
      	for(int i=num.length-1; i>=0;i--){
      		if(num[i] > partitionNum){
      			int changeNum = num[i];
      			num[i]=partitionNum;
      			num[partitionIndex] = changeNum;
      			break;
      		}
      	}
      	
      
      //reverse all the digits on the right of the partition index;
        swap(num, partitionIndex+1, num.length-1);
    }
    
    
    private void swap(int[] num, int start, int end){
      while(start<end){
      		int temp = num[start];
      		num[start]=num[end];
      		num[end]=temp;
      		start++;
      		end--;
      }
    }
    
}

/*
note: the mistake I have made: find the first element needs to use break in the loop!!!!!
*/


