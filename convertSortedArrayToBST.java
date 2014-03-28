/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

*/
public class Solution{
	public TreeNode sortedArrayToBST(int[] num){
		//don't forget to check input!!!!
		if(num.length == 0)
			return null;
		return sortedArrayToBST(num, 0, num.length-1);

}
	TreeNode sortedArrayToBST(int[] num, int start, int end){
		//base case
		if(start> end)
			return null;
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(num[mid]);
		root.left=sortedArrayToBST(num, start, mid-1);
		root.right = sortedArrayToBST(num, mid+1,end);
		return root;

}


}
