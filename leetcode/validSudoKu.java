/*
leetcode :

Valid Sudoku

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

*/


public class Solution{
    public boolean isValidSudoku(char[][] board){
	    //check each row
		for(int i =0; i<9; i++){
			boolean[] checker = new boolean[10];
			for(int j=0; j< 9;j++){
				if(board[i][j]=='.')
					continue;
				int temp = board[i][j]-'0';
				if(checker[temp])
					return false;
				checker[temp]= true;
			}
		}	
	    //check each col
		for(int i =0; i< 9;i++){
			boolean[] checker = new boolean[10];
			for(int j =0; j< 9;j++){
				if(board[j][i] == '.')
					continue;
				int temp = board[j][i] -'0';
				if(checker[temp])
					return false;
				checker[temp]=true;
			}
		}

		//check each subbox
		for(int r =0; r<3; r++){
			for(int c=0; c<3; c++){
				boolean[] checker = new boolean[10];
				for(int i =3*r; i< 3*r+3; i++){
					for(int j = 3*c; j<3*c+3; j++){
						if(board[i][j] == '.')
							continue;
						int temp = board[i][j]-'0';
						if(checker[temp])
							return false;
						checker[temp] = true;
					}
				}
			}
		}
	    return true;
	}
}

/*
should we just check the case 9 row, 9 col, 9 subbox???
the first mistake: boolean checker index from 0 not 1
have difficulty to loop subbox , 

and note the matched {} of "for" loop
*/
