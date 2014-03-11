/*
11.5 Given a sorted array of Strings, which is intersperse with empty strings,
write a method to find the location of a given string.
*/

int searchString(String[] arr, String target){
	//check the input!!!
	//if others search empty string?  error? talk this issue
	if(arr == null || target == null || target="")
		return -1;

	return searchString(arr, target, 0, arr.length-1);
}

int searchString(String[] arr, String target, int left, int right){

	if(left < right)
		return -1;

	int mid = (left+right)/2;

	if(arr[mid].isEmpty()){
		while(true){

			int leftString = mid-1;
			int rightString = mid+1;

			//remember this is &&!!!
			if(leftString<left && rightString> right)
				return -1;

			if(leftString >= left && !arr[leftStrin].isEmpty()){
				mid = leftString;
				break;
			}

			if(rightString <=right && !arr[rigthString].isEmpty()){
				mid = rightString;
				break;
			}
			leftString--;
			rightString++;
		}
	}
	//remember: compart two sting use equals, compareTo methods
	if(arr[mid].equals(target))
		return mid;
	else if(arr[mid].compareTo(target)<0)
		return searchString(arr,target, mid+1, right);
	else if(arr[mid].copareTo(target)>0)
		return searchString(arr, target, left, mid-1);

}
