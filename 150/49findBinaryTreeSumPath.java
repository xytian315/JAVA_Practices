/*
4.9 You are given a binary tree in which each node 
contains a value. Design an algorithm to print all paths
which sum to a given value. The path does not need to start
or end at the root or a leaf.


Note: The path of a binary tree : 
the direction is always from root to the leaves!!!!
Recursive!!!!!!!!!!!!!!!!
recurse through each node n, add the nodes along the path in reverse order from n to root
*/

void findSumPath(TreeNode root, int sum){
	int depth = depth(root);

	int[] path = new int[depth];

	return findSumPath(root,sum, path, 0);

}

int depth(TreeNode node){
	if(node == null)
		return 0;
	return 1+ Math.max(depth(node.left),depth(node.right));
}

void findSumPath(TreeNode node, int sum, int[] path, int level){
	if(node == null)
		return;

	path[level] = node.data;

	int t=0;
	for(int i = level; i>=0; i--){
		t +=path[i];
		if( t== sum)
			printPath(path, i, level);
	}

	findSumPath(node.left, sum,path, level+1);
	findSumPath(node.right, sum, path, level+1);

}


void printPath(int[] path, int i, int level){
	for(int j = i; j<= level; j++)
		System.out.print(path[j]+" ");
	System.out.println();
}
