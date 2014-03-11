/*
4.8 You have two very larger binary trees T1, with millions of nodes,
and T2, with hundreds of nodes. Create an algorithm to decide if 
T2 is a subtree of T1.

NOTE: following solution takes O(logn) space, O(n+km)time!!!!!!
*/

public boolean subTree(TreeNode t1, TreeNode t2){
	//don't forget to check the input
	//any null tree is the subTree of other tree
	if(t2 == null)
		return ture;
	return subTreeHelper(TreeNode t1, TreeNode t2);
}

public boolean subTreeHelper(TreeNode t1, TreeNode t2){

	//not find the match data until hit the null(leaf)
	if(t1== null)
		return false;

	if(t1.data == t2.data)
		return matchTree(t1, t2);

	return subTreeHelper(t1.left, t2) || subTreeHelper(t1.right,t2);
}

public boolean matchTree(TreeNode r1, TreeNode r2){
	//base case
	if(r1 == null && r2 == null)
		return true;

	if(r1 == null || r2 == null)
		return false;

	if(r1.data!= r2.data)
		return false;

	return matchTree(r1.left, r2.left)&& matchTree(r1.right,r2.right);

}
