/*
4.1 implement a function to check if a binary  tree is balanced. 
For the purposes of this question, a balanced tree is defined to be a 
tree such that the heights of the two subtrees of any node never differ
by more than one.
*/

public class Solution{
	
	// if the subtree is balanced, then checkHeight will return the current height
	// if not will return -1;
	public static int checkHeight(TreeNode node){
		if(node == null)
			return 0; 

		//check if left node is balanced
		int leftHeight = checkHeight(node.left);

		if(leftHeight == -1)
			return -1;

		//check if right node is balanced
		int rightHeight = checkHeight(node.right);
		if(rightHeight == -1)
			return -1;

		//check if current node is balanced
		int heightDiff = Math.abs(leftHeight - rightHeight);

		if(heightDiff >1)
			return -1;

		return Math.max(node.left.data, node.right.data)+1;


	}

	public static boolean isBalanced(TreeNode node){
		if(checkHeight(node) == -1)
			return true;
		else
			return false;
	}

}
