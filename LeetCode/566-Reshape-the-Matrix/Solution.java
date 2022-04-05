import java.util.Arrays;

/**
 * TASK
 * https://leetcode.com/problems/reshape-the-matrix/submissions/
 * 
 * In MATLAB, there is a handy function called reshape which can reshape 
 * an m x n matrix into a new one with a different size r x c keeping its 
 * original data.
 * 
 * You are given an m x n matrix mat and two integers r and c representing 
 * the number of rows and the number of columns of the wanted reshaped matrix.
 * 
 * The reshaped matrix should be filled with all the elements of the original 
 * matrix in the same row-traversing order as they were.
 * 
 * If the reshape operation with given parameters is possible and legal, output 
 * the new reshaped matrix; Otherwise, output the original matrix.
 * 
 */

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if ( r * c != mat.length * mat[0].length ){
            return mat;
        }
        
        int resColInd = 0;
        int resRowInd = 0;

        int[][] res = new int[r][c];

        for ( int i = 0; i < mat.length; ++i ){
            for ( int j = 0; j < mat[0].length; ++j ){
                if ( resColInd == res[0].length && resRowInd + 1 < res.length ){
                    resRowInd++;
                    resColInd = 0;
                }
                res[resRowInd][resColInd] = mat[i][j];
                resColInd++;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        
        int[][] r1 = {{1,2},{3,4}};
        int a1 = 1;
        int b1 = 4;
        int[][] r2 = {{1,2},{3,4}};
        int a2 = 2;
        int b2 = 4;


        Solution s = new Solution();
        int[][] res1 = s.matrixReshape(r1, a1, b1);
        System.out.println(Arrays.deepToString(r1));
        System.out.println(Arrays.deepToString(res1));
        System.out.println();
        int[][] res2 = s.matrixReshape(r2, a2, b2);
        System.out.println(Arrays.deepToString(r2));
        System.out.println(Arrays.deepToString(res2));



    }
}