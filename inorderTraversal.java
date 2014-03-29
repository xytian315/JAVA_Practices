/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/
//recursive 
public class Solution {
	public ArrayList<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();

		inorderTraversal(root,result);
		return result;
	}
	
	void inorderTraversal(TreeNode root, ArrayList<Integer> result){	
		if(root == null)
			return;
		inorderTraversal(root.left,result);
		result.add(root.val);
		inorderTraversal(root.right,result);
	}

}

//iterative

 
public class Solution{

	public ArrayList<Integer> inorderTraversal(TreeNode root){

		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if(root == null)
			return result;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode current = root;

		while(current!= null || !stack.isEmpty()){

			if(current!=null){
				stack.push(current);
				current = current.left;
			}else{
				TreeNode n = stack.pop();
				result.add(n.val);
				current = n.right;
			}
		}
		return result;

}

}
		
