import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**************************************************************
 * 1727. Largest Submatrix With Rearrangements
 * 
 * You are given a binary matrix matrix of size m x n, 
 * and you are allowed to rearrange the columns of the 
 * matrix in any order.
 * 
 * Return the area of the largest submatrix within matrix 
 * where every element of the submatrix is 1 after reordering 
 * the columns optimally.
 * 
 */

 /**
  * Решение:
  *     Так как перемещать можно только столбцы, то для того 
  * чтобы понять какие столбцы переметсить необходимо определить 
  * количество в каждом столбце.
  *     Кроме того это дает возможность оценить размер возможной
  * подматрицы. 
  *
  */

public class Solution {

    public int largestSubmatrix(int[][] matrix) {
        int MaxSubMatrix = 0;
        int rowNumber = matrix.length;
        int colomnNumber = matrix[0].length;

        int[] colomHeight = new int[colomnNumber];

        for ( int i = 0; i < rowNumber; i++ ){

            // calculate heights
            for ( int j = 0; j < colomnNumber; j++ ) { 
                if ( matrix[i][j] == 0 ){
                    colomHeight[j] = 0;
                } else {
                    colomHeight[j] += 1;
                }  
            }

			// sort colomns
            int[] sortedColomHeight = colomHeight.clone();
            Arrays.sort(sortedColomHeight);

            for(int j = 0; j < sortedColomHeight.length; j++ ){
                MaxSubMatrix = Math.max(MaxSubMatrix, 
                    ( sortedColomHeight[j] * (sortedColomHeight.length - j) ));
            }

        }

        return MaxSubMatrix;
    }


    public static void printSqrMatrix(int[][] matrix){
        int rowNumber = matrix.length;
        int colomnNumber = matrix[0].length;

        for ( int i = 0; i != rowNumber; i++ ) {
            for ( int j = 0; j != colomnNumber; j++ ) {
                System.out.print(matrix[i][j]);
            }
            System.out.println(",");
        }
    }

    public static void printMatrix(int[] matrix){
        int size = matrix.length;
        System.out.print("[");
        for ( int i = 0; i != size; i++ ) {
                System.out.print(matrix[i] + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[][] matrix1 =   { {1, 1, 1, 1,},
                              {0, 0, 0, 0},
                              {0, 0, 0, 0,},
                              {0, 0, 0, 0,}
                            };
        
        // Solution.printSqrMatrix(matrix1);
        System.out.println();
        Solution a = new Solution();
        System.out.println("Max Submatrix " + a.largestSubmatrix(matrix1));



    }
}

/*
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int MaxSubMatrixSum = 0;
        int rowNumber = matrix.length;
        int colomnNumber = matrix[0].length;

        int rowsSum[][] = new int[rowNumber][colomnNumber];
        
        for (int i = 0; i < colomnNumber; i++ ){
            int currentSeria = 0;

            for ( int j = rowNumber - 1; j >= 0; j-- ) {
                if( matrix[j][i] == 1 ){
                    currentSeria += 1;
                    rowsSum[j][i] = currentSeria;
                } else {
                    currentSeria = 0;
                    rowsSum[j][i] = 0;
                }     
            }
        }
        // printSqrMatrix(rowsSum);

        for ( int i = 0; i < rowNumber; i++ ){
            int currentMaxSubMatrix = 0;

            for ( int j = 0; j < colomnNumber; j++ ) {
                if ( rowsSum[i][j] == 0 ) {
                    continue;
                }     

                int thisRowMaxSubMatrix = 0;
                for ( int k = 0; k < colomnNumber; k++ ){
                    if ( rowsSum[i][k] >= rowsSum[i][j] ){
                        thisRowMaxSubMatrix += rowsSum[i][j];
                    }
                }

                if (thisRowMaxSubMatrix > currentMaxSubMatrix){
                    currentMaxSubMatrix = thisRowMaxSubMatrix;
                }
            }

            if ( currentMaxSubMatrix > MaxSubMatrixSum ) {
                MaxSubMatrixSum = currentMaxSubMatrix;
            }
        }

        return MaxSubMatrixSum;
    }
}
*/