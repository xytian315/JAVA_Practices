/*
11.6 Given an M*N matrix in which each row and each column is sorted in ascending
order, write a method to find an element.


Note: start from matrix[o][col]!!!!!!
*/

boolean findElement(int[][] matrix, int element){

	int row= 0;
	int col = matrix[0].length-1;

	while(row < matrix.length&& col>=0){

		if(matrix[row][col] == element)
			return true;

		else if(matrix[row][col] < element)
			row++;
		else if(matrix[row][col] > element)
			col--;

	}
	return false;
}
