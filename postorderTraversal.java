/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
*/
//recursive 
public class Solution {
	public ArrayList<Integer> postorderTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();

		postorderTraversal(root,result);
		return result;
	}
	
	void postorderTraversal(TreeNode root, ArrayList<Integer> result){	
		if(root == null)
			return;
		postorderTraversal(root.left,result);
		postorderTraversal(root.right,result);
		result.add(root.val);
		
	}

}

//iterative

 
public class Solution{

	public ArrayList<Integer> postorderTraversal(TreeNode root){
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		//check input
		if(root == null)
			return result;

		//use stack to process
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		//use a previous node to mark the process
		TreeNode prev = null;

		while(!stack.isEmpty()){
			
			TreeNode Tercurrent = stack.peek();
			//process the tree
			//check if the current node is leaf, if so, process the tree, else keep going
			if(prev == null || prev.left == current || prev.right == current){
				if(current.left!= null)
					stack.push(current.left);
				else if(current.right!= null)
					stack.push(current.right);
				else{
					TreeNode n = stack.pop();
					result.add(n.val);	
				}
			
			//go up the tree from left node, check if has the right node, if it has push to stack, other wise process the parent and pop	     
			}else if(current.left == prev){

				if(current.right!=null)
					stack.push(current.right);
				else{
					TreeNode n = stack.pop();
					result.add(n.val);
				}
			//go up the tree from the right node, process the parent node, and pop 
			}else if(current.right == prev){
				TreeNode n = stack.pop();
				result.add(n.val);
			}
			prev = current;
		}
		return result;
	}                                                                                                                                                                                                                                                        
}
		
