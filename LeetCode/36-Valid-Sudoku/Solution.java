import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * TASK
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to 
 * the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * 
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */

class Solution {
    
    public boolean isValidSudoku(char[][] board) {

        for ( int i = 0; i < board.length; ++i ){
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> cubeSet = new HashSet<>();

            for ( int j = 0; j < board[0].length; ++j ){
                // ищем дублирование данного числа в i-ом ряду 
                if ( board[i][j] != '.' && !rowSet.add(board[i][j]) ){
                    return false;
                }
                // ищем дублирование данного числа в i-ом столбце 
                if ( board[j][i] != '.' && !colSet.add(board[j][i]) ){
                    return false;
                }
                
                // rowCubeInd и colCubeInd это координаты левой верхней ячейки 
                // одного из 9 квадратов в поле игры
                int rowCubeInd = 3*(i/3);
                int colCubeInd = 3*(i%3);
                if ( board[rowCubeInd + j/3][colCubeInd + j%3] != '.' 
                    && !cubeSet.add(board[rowCubeInd + j/3][colCubeInd + j%3]) ){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
         
        char[][] board1 = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                            { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                            { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                            { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                            { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                            { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        char[][] board2 = { {'8', '3', '.', '.', '7', '.', '.', '.', '.' },
                            {'6', '.', '.', '1', '9', '5', '.', '.', '.' },
                            {'.', '9', '8', '.', '.', '.', '.', '6', '.' },
                            {'8', '.', '.', '.', '6', '.', '.', '.', '3' },
                            {'4', '.', '.', '8', '.', '3', '.', '.', '1' },
                            {'7', '.', '.', '.', '2', '.', '.', '.', '6' },
                            {'.', '6', '.', '.', '.', '.', '2', '8', '.' },
                            {'.', '.', '.', '4', '1', '9', '.', '.', '5' },
                            {'.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        System.out.println( Arrays.deepToString(board1) );
        System.out.println( Arrays.deepToString(board2) );


        for (int i = 0; i < 9; ++i ){
            int rowCubeInd = (i/3);
            int colCubeInd = (i%3);
            System.out.println(i + ")\trowCubeInd = " + rowCubeInd );
            System.out.println("\tcolCubeInd = " + colCubeInd );
        }

        Solution s = new Solution();
        System.out.println( s.isValidSudoku(board1) );
        System.out.println( s.isValidSudoku(board2) );

    }
}