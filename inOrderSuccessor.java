/*
4.5 Write an algorithm to find the next node(i.e in order traversal) of a given node 
in a binary search tree. You may assume that each node has a link to its parent;
*/


public class Solution{
	
	public TreeNode inOrderSuccessor(TreeNode node){

		if(node == null)
			return null;

		//if the current node has right subtree
		if(node.right!= null){
			return leftMost(node.right);
		}else{

			//Go up untill we are on left side.!!!!!!!!

			TreeNode current = node;
			TreeNode parent = node.parent;
			while(parent!= null && parent.left!= current){
				current = parent;
				parent = parent.parent;
			}
			return parent;

		}

	}


	TreeNode leftMost(TreeNode n){
		if(n== null)
			return null;

		while(n.left!=null){
			n = n.left;
		}
		return n;
	}
}

