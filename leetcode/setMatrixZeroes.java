/*
leetcode
Set Matrix Zeroes

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        //initialize two booleans to mark the first row and the first column
        boolean firstRow = false;
        boolean firstCol = false;
        //check first row
        for(int i =0; i< matrix[0].length;i++){
            if(matrix[0][i] == 0){
                firstRow = true; 
                break;  //the first mistake: don't forget the break!!!
            }
        }
        //check first col
        for(int i =0; i< matrix.length;i++){
            if(matrix[i][0] == 0){
                firstCol = true;
                break;
            }
                
        }
        //loop other elements except the first row and the first col, use corresponding first row/col index to mark zero
        for(int i =1 ; i< matrix.length; i++){
            for(int j=1; j< matrix[0].length; j++){
                if(matrix[i][j] ==0){
                    matrix[0][j] =0;
                    matrix[i][0] =0;
                }
            }
        }
        
        //loop other elemnts except the first row and the first col, based on the mark, set corresponding col/row elments to zero
        //the second mistake: use two for loops!!
        for(int i =1; i< matrix.length;i++){
            for(int j =1; j< matrix[0].length;j++){
                if(matrix[i][0]==0 || matrix[0][j] ==0)
                    matrix[i][j] =0;
            }
        }

        //set the first row and the first column based on the boolean 
        if(firstRow){
            for(int i =0; i< matrix[0].length; i++)
                matrix[0][i] =0;
        }
        
        if(firstCol){
            for(int i =0; i<matrix.length;i++)
                matrix[i][0] =0;
        }
    }
}
