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
do not know the hash table iterate is ordered

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



