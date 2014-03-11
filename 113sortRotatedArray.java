/*
11.3 Given a sorted array of n integers that has been rotated an unknown
number of time, write code to find an element in the array. You may assume 
that the array was originally sorted in increasing order.
*/

int searchTarget(int[] arr, int target){
	return search(arr, 0, arr.length-1, target);
}

int search(int[] arr, int left, int right, int target){

	int mid = (left+right)/2;

	if(arr[mid] == target)
		return mid;

	if(right < left)
		return -1;

	if(arr[left] < arr[mid]){

		if(arr[left]<= x && arr[mid]>= x){
			return search(arr, left, mid -1, target);
		}else{
			return search(arr, mid+1, right, target);
		}	
	
	}else if(arr[left] > arr[mid]){
		if(arr[mid]<= x && arr[right]>=x){
			return search(arr, mid+1, right, target);
		}else{
			return search(arr, left, mid-1, target);
		}
	}else if(arr[left]==arr[mid]){
		//when arr[left]==arr[mid]
		if(arr[right] != arr[mid])
			//only need to search the right half since the left half would be the same
			return search(arr, mid+1, right, target);
		else{
			//need to search both the left and right, since we don't know which half would have the same elements
			int leftResult = search(arr, left, mid-1,target);
			if(leftResult == -1)
				leftResult= search(arr,mid+1,right, target);
			return leftResult;
		}

	}


	return -1;

}
