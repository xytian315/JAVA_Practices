/*
Leetcode: Set Matrix Zeroes

Given a m * n matrix, if an element is 0, set its entire row and column to 0. Do it in place

hint: use the matrix itself to store the status!!!
*/

public void setZeroes(int[][] matrix) {

	boolean firstRow = false;
	boolean firstCol = false;

	//check whether there is 0 in the first row and column, use two flags to store status
	for(int i = 0; i< matrix[0].length; i++){
		if(matrix[0][i] == 0){
			firstRow = true;
			break;
		}
	}

	for(int i = 0; i< matrix.length; i++){
		if(matrix[i][0]==0){
			firstCol = true;
			break;
		}
	}

	//check other rows and columns if there is 0, use the first row and column to store the status
	for(int i = 1; i<matrix.length;i++){
		for(int j=1; j< matrix[0].length;j++){
			if(matrix[i][j]==0){
				matrix[i][0] = 0;
				matrix[0][j] =0;
			}

		}
	}

	//set the other rows and columns to zeroes according to the status of the first row and column 
    for(int i=1;i<matrix.length;i++){
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[i][0]==0 || matrix[0][j]==0){
                matrix[i][j]=0;
            }
        }
    }

    //set the first row and column according to previous flags
    if(firstRow){
        for(int i=0;i<matrix[0].length;i++)
            matrix[0][i]=0;
    }
        
    if(firstCol){
        for(int i=0;i<matrix.length;i++)
            matrix[i][0]=0;
    }

}
