/*
leetcode
You are given an n × n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
Follow up: Could you do this in-place?

*/

/*
thought:首先沿着副对角线翻转一次,然后沿着水平中线翻转一次。
*/

public class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        //first rotate the elements besides the diagonal 
        //the mistake: be careful to write the index of the correspondint elements besides the diagonal, the row and col index is different 
        for(int i =0; i< row-1; i++){
            for(int j =0; j< col-1-i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row-1-j][col-1-i];
                matrix[row-1-j][col-1-i] = temp; 
            }
        }
        
        //rotate the elements besides middle part
        for(int i =0; i< row/2;i++){
            for(int j =0; j< col;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row-1-i][j];
                matrix[row-1-i][j] = temp;
            }
        }
    }
}
