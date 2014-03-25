/*

Write a function that determines the number of 1 bits in the binary representation of a given integer


*/

int findOnesInBinary(int num){
	int count =0;
	
	while(num!=0){
		if(num & 1 ==1){
			count ++;
		}
		num = num <<< 1; //works in unsigned Integer
	}
	
	return count;
}
