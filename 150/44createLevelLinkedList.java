/*
4.4 Given a binary tree, design an algorithm which creates a linekd list of 
all the nodes at each depth(e.g. if you have a tree with depth D, you will 
have D linekd list)
*/

//breadFirst Search
public class BFSSolution{
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){

		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

		LinkedList<TreeNode> current;

		if(root!= null)
			current.add(root);

		while (current.size() >0){

			result.add(current);

			LinkedList<TreeNode> parents = current;

		    current = new LinkedList<TreeNode>();

			for(TreeNode parent: parents){
				if(parent.left!= null)
					current.add(parent.left);

				if(parent.right!= null){
					current.add(parent.right);
				}
			}
		} 

		return result;

	}
		
}

// pre-order traversal
public class DFSSolution2{

	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
		ArrayList<LinkeList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

		createLevelLinkedList(root, result, 0);

	}

	public void ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> result, int level){
		//base case!!!!!!!
		if(root == null)
			return;

		LinkedList<TreeNode> current;
		if(result.size() == level){
			current = new LinkedList(current);
			result.add(current);
		}
		else{
			current = result.get(level);
		}
		
		current.add(root);
		createLevelLinkeList(root.left,result,level+1);
		createLevelLinkedList(root.right, result, level+1);

	}



}

