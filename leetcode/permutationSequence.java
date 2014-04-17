/*

leetcode
Permutation Sequence

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.


*/

//? other method?? 康托编码?????


//my code: use next Permutation's method
public class Solution {
    public String getPermutation(int n, int k) {
 		
 		//check the input
 		StringBuilder sb = new StringBuilder();
 		if(n<=1){
     		sb.append(n);
     		return sb.toString();
 		}	 
 		
 		//initiate the array
 		int arr[] = new int[n];
 		for(int i =0; i<n; i++){
 		    arr[i]=i+1;
 		}
 	
 		for(int i =1; i<k; i++){
 		
 			//first find the first partition number
 	
 			int partitionIndex =-1;
 		    int partitionNum =0;
 			int previous = arr[arr.length-1];
 			int changeNum =0;
 			
 			for(int j =arr.length-2;j >=0;j--){
 				if(arr[j]<previous){
 					partitionNum = arr[j];
 					partitionIndex = j;
 					break;
 				}
 				previous = arr[j]; //don't forget to change previous every time!
 			}
 			//if partitionIndex=-1; it is the last order
 			
 			if(partitionIndex == -1){
 				reverse(arr, 0, arr.length-1);
 				k=k%i;   //don'r forget to add this to save the time, save the loop!!!!
 				continue; 
 			}
 			
 			
 			//find the first change number
 			for(int m = arr.length-1; m>=0;m--){
 				if(arr[m]>partitionNum){
 					changeNum = arr[m];
 					//swap the changeNum and partitionNum
 					arr[m]= partitionNum;
 					arr[partitionIndex] = changeNum;
 					break;
 				}
 			}
 			
 			//reverse the right elements of the partitionIndex
 			reverse(arr, partitionIndex+1, arr.length-1);
 		
 		}
 		
 		//change the array to string
 	
 		for(int i =0; i<arr.length;i++){
 			sb.append(arr[i]);
 		}
 		
 		return sb.toString();
 		       
    }
    
    private void reverse(int[] arr, int start, int end){
    	while(start< end){
    		int temp = arr[start];
    		arr[start] = arr[end];
    		arr[end] = temp;
    		start++;
    		end--;
    	}
    }
    
}
