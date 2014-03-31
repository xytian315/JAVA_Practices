/*

Question: If you had an array that was randomly filled with numbers between 0 and 10 
can you write an algorithm/function 
that is able to find the largest sum of any two numbers in this array. 
What are the different ways you can implement this?
What is the fastest method that implements this function?
ex. def FindLargestSum(numbers) where numbers = [6,2,9,3,7,4,5]

*/

/*

by Kristy Tian

The ways to resolve this question: 

1. Naive approach : Use two nested for loops to track every pair of the numbers in the array,
then find the largest sum. 
The time complexity is O(n^2)

2. Sort approach: We can first sort the array, then the sum of the last two numbers is the largest sum.
The time complexity is O(nlogn) for sorting.

3. Heap approach: we can build a max heap of the array, then deleting the first two elements from the heap,
the largest sum is the sum of these two numbers.
The time complexity is O(nlogn) for building heap.  

4. Faster approach: See followed codes.
Firt we build an array digits[11], the index i representing the digits from 0-10,
the value digits[i] representing the number of occurences of the digits in the input array.
then we compute the digits[11] from the reverse order to find the largest sum. 

The time complexity is O(n).

*/

public class Solution {
	
	public final static int SIZE = 11;
	public final static int DEFAULT_COUNT =2;
	
	public static int findLargestSum(int[] array){
		
		int count=DEFAULT_COUNT;
		
		if(array.length < count)
			return -1; //or throw an exception, no enough elements in the array

		//initialize an array to store all the digits from 0 -10
		int[] digits = new int[SIZE];

		for (int i =0 ; i< digits.length; i++){
			digits[i] =0;
		}

		//loop the input array, count the digits 

		for(int i=0 ; i< array.length; i++){

			digits[array[i]]++;
		}

		int sum =0;

		//loop from the last index of the digit array
		for(int i = digits.length-1; i>=0; i--){
			if(count == 0)
				break;
			if(digits[i] < 2){
				sum += digits[i]*i;
				count = count - digits[i];
			}
			else{
				sum += count *i;
				count =0;
			}
		}

		return sum;
	}
	
	//used for testing
	public static void main(String[] args) {
		
		int[] array = {6,2,9,3,7,4,5};
		int result = findLargestSum(array);
		System.out.println(result);
		
		int[] array2 = {9,8,8};
		int result2 = findLargestSum(array2);
		System.out.println(result2);
		
		int[] array3 = {0};
		int result3 = findLargestSum(array3);
		System.out.println(result3);
		
		int[] array4 = {8,8,9,9};
		int result4 = findLargestSum(array4);
		System.out.println(result4);
		
		int[] array5 = {8,8,9,9,9};
		int result5 = findLargestSum(array5);
		System.out.println(result5);
		
	}
	
}
}
