import java.util.Stack;

/****************************************************************************
 * You are given an m x n binary matrix grid. An island is a group of 1's 
 * (representing land) connected 4-directionally (horizontal or vertical.) 
 * You may assume all four edges of the grid are surrounded by water.
 * 
 * The area of an island is the number of cells with a value 1 in the island.
 * 
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */

class Solution {

    public int floodFill(int[][] image, int sr, int sc ) {
        int imageCol = 1;
        int newColor = 2;
        if ( imageCol == newColor ){
            return 0;
        }
        
        int pixelCount = 0;

        Stack<int[]> pixelStack = new Stack<>();
        pixelStack.push( new int[]{sr, sc} );
            
        while( !pixelStack.isEmpty() ){
            int[] currentPixel = pixelStack.pop();
            int currentRow = currentPixel[0];
            int currentCol = currentPixel[1];

            if ( image[currentRow][currentCol] == imageCol ){
                ++pixelCount;
                image[currentRow][currentCol] = newColor;   
            }

            if( currentRow - 1 >= 0 && image[currentRow - 1][currentCol] == imageCol ){
                pixelStack.push( new int[]{currentRow - 1, currentCol} );
            } 
            if( currentRow + 1 < image.length && image[currentRow + 1][currentCol] == imageCol ){
                pixelStack.push( new int[]{currentRow + 1, currentCol} );
            } 
            if( currentCol - 1 >= 0 && image[currentRow][currentCol - 1] == imageCol ){
                pixelStack.push( new int[]{currentRow, currentCol - 1} );
            } 
            if( currentCol + 1 < image[0].length && image[currentRow][currentCol + 1] == imageCol ){
                pixelStack.push( new int[]{currentRow, currentCol + 1} );
            }

        }

        return pixelCount;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for ( int i = 0; i < grid.length; ++i ){
            for ( int j = 0; j < grid[0].length; ++j){
                if ( grid[i][j] == 1){
                    maxArea = Math.max(floodFill(grid, i, j), maxArea) ;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int a = 'a';
        System.out.println(a);
    }
}