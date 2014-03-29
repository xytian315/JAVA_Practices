/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
*/
//recursive 
public class Solution {
	public ArrayList<Integer> preorderTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		preorderTraversal(root, result);
		return result;
	}
	
	void preorderTraversal(TreeNode root, ArrayList<Integer> result){	
		if(root == null)
			return;
		result.add(root.val);
		preorderTraversal(root.left,result);
		preorderTraversal(root.right,result);
	}

}

//iterative using stack first push right, then push left
//don't forget to check input

public class Solution{
	public ArrayList<Integer> preorderTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if(root == null)
			return result;
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while(!s.isEmpty()){
			TreeNode current = s.pop();
			result.add(current.val);
			
			if(current.right!=null)
				s.push(current.right);
			if(current.left!=null)
				s.push(current.left);
			
		}
		return result;

	}

}


