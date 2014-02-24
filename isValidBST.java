/*
check if it is a valid balanced search tree
*/

public class Solution{
	public static boolean isValidBST(Node root){
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBST(Node root, int min, int max){
		if(root.right!=null){
			if(root.right > max || !isValidBST(root.right,root.data,max))
				return false;
		}
		if(root.left!= null)
			if(root.left < min || isValidBST(root.left, min,root.data))
			return false;
	}
	return true;

}

