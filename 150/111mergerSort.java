/*
11.1 You are given two sorted arrasys A and B, 
where A has a large enough buffer at the end to hold B.
Write a method to merge B into A in sorted order
*/

//sizeA and sizeB is the current actual number of elements in array a, b
void mergeSort(int[] a, int[] b, int sizeA, int sizeB){
	int indexA = sizeA-1;
	int indexB = sizeB-1;
	int mergerIndex = sizeA+sizeB -1;

	while(indexB >=0){
		//don't forget to put indexA>=0 here!!!!! 
		//since it is possible all the numbers in A greater than B
		if(indexA >=0 &&a[indexA]> b[indexB]){
			a[mergeIndex]=a[indexA];
			indexA--;
		}else{
			a[mergeIndex]= b[indexB];
			indexB--;
		}
		mergeIndex--;

	}

}
