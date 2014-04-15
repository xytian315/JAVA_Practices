/*
leetcode
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/
//recursive
public class Solution{

	public int minDepth(TreeNode n){

		if(n == null)
			return 0;
		if(n.left == null && n.right == null)
			return 1;

		if(n.left == null){
			return 1+minDepth(n.right);
		}
		if(n.right == null)
			return 1+minDepth(n.left);
		if(n.left!=null && n.right!=null)
			return 1+ Math.min(minDepth(n.left),minDepth(n.right));
	}

}

public class Solution {
 
	public int minDepth(TreeNode root){
		//don't forget to check null
		if(root == null)
			return 0;
		//use ArrayList to store the parent node
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		nodes.add(root);
		int count = 1;
		
		while(!nodes.isEmpty()){
			//make a new ArrayList to store the current node from parents and it will become parent nodes
			ArrayList<TreeNode> current = new ArrayList<TreeNode>();
			
			for(TreeNode n : nodes){
				//leaf
				if(n.left == null && n.right == null)
					return count;
				if(n.left!=null)
					current.add(n.left);
				if(n.right!=null)
					current.add(n.right);
				 
			}
			count++;
			nodes= current;	
		}
		return count;
	}
}
