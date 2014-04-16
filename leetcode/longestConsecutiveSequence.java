/*
leetcode: 

Longest Consecutive Sequence

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

*/
/*
note: 

when the array is not sorted, and time complexity needs to be O(n), 
always think about HashTable!!!!!




difficulty: thinking about hashtable, but how to store the value?


use HashSet, and iterate the elements, check the left elements and right elements of each element,

after check, remember to remove it!!!!




*/


import java.util.HashSet;
public class Solution {
	public int longestConsecutive(int[] num){
		
		Set<Integer> set = new HashSet<Integer>();
		
		//add all the numbers into a set
		for(int i : num)
			set.add(i);
			
		int result =0;
		
		//iterate all the elements and check the left and right
		for(int i : num){
			int count =1;
			int left = i-1;
			int right = i+1;
			
			//check the left elements
			while(set.contains(left)){
				count++;
				set.remove(left); // most important, remove the elements
				left--;
			
			}
			//check the right elements
			while(set.contains(right)){
				count++;
				set.remove(right);
				right++;			
			}
			
			result = Math.max(count, result);
		
		}	
		return result;
		
	
	}


}




/*



Start from one of them, iterate upwards and downwards to find the longest consecutive sequence, 
and set visited flag for each visited number.

Think as cluster merge, a single number is a length=1 cluster.

The key factors about a cluster is: lowest, highest, and length.
Map lowest and highest to length. To merge two neighbor clusters, only need to update it's new lowest and highest, with new length.
For every a[i], checking its neighbor a[i]-1 and a[i]+1 is enough.
http://discuss.leetcode.com/questions/1070/longest-consecutive-sequence 

*/


//not efficient O(n2)

public class Solution {
    public int longestConsecutive(int[] num) {
        
        Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();

        //put all the elements in the Hashtable
        for(int i: num)
        	table.put(i,false);

        int result =0;
        //iterate all the numbers
        for(int i: num){
        	if(!table.get(i)){
        		table.put(i,true);  //set the flag to indicate it has already been visited
        		int length = 1+ findLongestHelper(table,i-1,-1)+findLongestHelper(table,i+1,1);
        		result = Math.max(result,length);
        	}
        }

        return result;
    }

    //use step to indicate whether it is upwards or downwards
     private int findLongestHelper(Hashtable<Integer,Boolean> table ,int num,int step){
    	int result =0;

    	while(table.contains(num)){
    		result++;
    		table.put(num,true); //set the flag;
    		num=num+step;  //use step to indicate upwards or downwards
    	}

    	return result;
    }
}



