/*
leetcode
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Thoughts

Go down through the left, when right is not null, push right to stack.
*/
//recursive
public class Solution{
	public void flatten(TreeNode root){
		TreeNode n = root;
		//use stack to store right nodes
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(n!= null || !stack.isEmpty()){
			if(n.right!=null){
				stack.push(n.right);
			}
			//link to left node
			if(n.left!=null){
				n.right = n.left;
				n.left = null;
			}else if(!stack.isEmpty()){ //if there is no left node process the right node stored from the stack
				TreeNode current = stack.pop();
				n.right = current;
			}
			n = n.right;
		}
	}
}
