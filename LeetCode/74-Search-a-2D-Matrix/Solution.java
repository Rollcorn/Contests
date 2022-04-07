/**
 * Write an efficient algorithm that searches for a value 'target' in an m x n integer 
 * matrix 'matrix'. This matrix has the following properties:
 *      * Integers in each row are sorted from left to right.
 *      * The first integer of each row is greater than the last integer of the previous row.
 * 
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int beginInd = 0;
        int endInd = matrix.length - 1;
        int rowMiddle = (endInd - beginInd) / 2;      

        // Поиск подходящей строки что таргет может лежать в данной строке
        while (  beginInd != endInd && !((matrix[rowMiddle][0] <= target) && (matrix[rowMiddle][matrix[0].length - 1] >= target)) ) {

            if ( target > matrix[rowMiddle][matrix[0].length - 1] ) {
                beginInd = rowMiddle + 1;
            } else
            if ( target < matrix[rowMiddle][0] ) {
                endInd = rowMiddle;
            } 

            // Проверка что мы не вышли за пределы массива
            if ( beginInd >= matrix.length || endInd < 0 ) {
                return false;
            } 
            // Обновляем середину 
            rowMiddle = beginInd + (endInd - beginInd) / 2;
        }
        
        beginInd = 0;
        endInd = matrix[0].length - 1;
        int colMiddle = (endInd - beginInd) / 2;  

        while ( endInd != beginInd && target != matrix[rowMiddle][colMiddle] ) {
            // Поиск таргета в строке
            if ( target > matrix[rowMiddle][colMiddle] ) {
                beginInd = colMiddle + 1;
            }
            if ( target < matrix[rowMiddle][colMiddle] ) {
                endInd = colMiddle;
            }

            colMiddle = beginInd + (endInd - beginInd) / 2;  
        }

        if (target == matrix[rowMiddle][colMiddle] ) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        int[][] matrix1 = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target1 = 3;
        int[][] matrix2 = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target2 = 13;
        int[][] matrix3 = {{1}};
        int target3 = 1;
        int[][] matrix4 = {{1}};
        int target4 = 2;
        int[][] matrix5 = {{1, 3}};
        int target5 = 3;
        int[][] matrix6 = {{1}, {3}};
        int target6 = 2;

        Solution s = new Solution();
        System.out.println( s.searchMatrix(matrix1, target1) );
        System.out.println( s.searchMatrix(matrix2, target2) );
        System.out.println( s.searchMatrix(matrix3, target3) );
        System.out.println( s.searchMatrix(matrix4, target4) );
        System.out.println( s.searchMatrix(matrix5, target5) );
        System.out.println( s.searchMatrix(matrix6, target6) );

    }
}