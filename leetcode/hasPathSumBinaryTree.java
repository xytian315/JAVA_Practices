/*
leetcode
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/
//use two queues to execute breadfirsttraversal, one queue to store the parent node(s), the other queue to store the value along the path

public class Solution {
	public boolean hasPathSum(TreeNode root, int sum){
		if(root == null)
			return false;
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<Integer> distance = new LinkedList<Integer>();
		
		nodes.add(root);
		distance.add(root.val);
		
		while(!nodes.isEmpty()){
			TreeNode current = nodes.pop();
			int path = distance.pop();
			//base case current node is leaf
			if(current.left == null && current.right == null && path == sum)
				return true;
			if(current.left!=null){
				nodes.add(current.left);
				distance.add(current.left.val+path);
			}
			if(current.right!= null){
				nodes.add(current.right);
				distance.add(current.right.val+path);
			}
		}
		return false;
}

}


//mysolution
public class Solution{
	public boolean hasPathSum(TreeNode root, int sum){
		//check input
		if(root == null)
			return false;
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		nodes.add(root);
		
		while(!nodes.isEmpty()){
			
			ArrayList<TreeNode> current = new ArrayList<TreeNode>();
			for(TreeNode node: nodes){
				if(node.left == null && node.right == null)
					if(node.val == sum)
						return true;
				if(node.left!= null){
					node.left.val = node.left.val +node.val;
					current.add(node.left);
				}
				if(node.right!=null){
					node.right.val = node.right.val + node.val;
					current.add(node.right);
				}
				
			}
			nodes = current;
		}
		return false;
	}	
}
