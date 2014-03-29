/*
check if it is a valid balanced search tree
*/

public class Solution {

	public boolean isValidBST(TreeNode root){
		return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);	
	}
	boolean isValidBST(TreeNode root, int min,int max){
		//base case
		if(root == null)
			return true;
		if(root.val <=min || root.val>=max)
			return false;
		return isValidBST(root.left,min,root.val)&&isValidBST(root.right,root.val,max);
	}

}
