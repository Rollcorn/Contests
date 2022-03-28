import java.util.Stack;

/**
 * TASK:
 * An image is represented by an m x n integer grid image where image[i][j] 
 * represents the pixel value of the image.
 * 
 * You are also given three integers sr, sc, and newColor. You should perform 
 * a flood fill on the image starting from the pixel image[sr][sc].
 * 
 * To perform a flood fill, consider the starting pixel, plus any pixels 
 * connected 4-directionally to the starting pixel of the same color as 
 * the starting pixel, plus any pixels connected 4-directionally to those 
 * pixels (also with the same color), and so on. Replace the color of all 
 * of the aforementioned pixels with newColor.
 * 
 * Return the modified image after performing the flood fill.
 * https://leetcode.com/problems/flood-fill/
 * 
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int imageCol = image[sr][sc];

        Stack<int[]> pixelStack = new Stack<>();

        pixelStack.push( new int[]{sr, sc} );
            
        while( !pixelStack.isEmpty() ){
            int[] currentPixel = pixelStack.pop();
            int currentRow = currentPixel[0];
            int currentCol = currentPixel[1];

            if ( image[currentRow][currentCol] != newColor ){
                image[currentRow][currentCol] = newColor;   
            }

            if( currentRow - 1 >= 0 && image[currentRow - 1][currentCol] == imageCol ){
                image[currentRow][currentCol] = newColor;   
                pixelStack.push( new int[]{currentRow - 1, currentCol} );
            } 
            if( currentRow + 1 < image.length && image[currentRow + 1][currentCol] == imageCol ){
                image[currentRow + 1][currentCol] = newColor;   
                pixelStack.push( new int[]{currentRow + 1, currentCol} );
            } 
            if( currentCol - 1 >= 0 && image[currentRow][currentCol - 1] == imageCol ){
                image[currentRow][currentCol - 1] = newColor;   
                pixelStack.push( new int[]{currentRow, currentCol - 1} );
            } 
            if( currentCol + 1 < image[0].length && image[currentRow][currentCol + 1] == imageCol ){
                image[currentRow][currentCol + 1] = newColor;   
                pixelStack.push( new int[]{currentRow, currentCol + 1} );
            }
        }

        return image;
    }

    public static void printArr(int[][] arr){
        System.out.println("[");
        for ( int i = 0; i < arr.length; ++i ){
            System.out.print("[ ");
            for (int j = 0; j < arr[0].length; ++j ){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("]");
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        int[][] s1 = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        System.out.println("s1.length=" + s1.length + " s1[0].length=" + s1[0].length);
        printArr(s1);
        Solution s = new Solution();
        s.floodFill(s1, 1, 1, 2);
        printArr(s1);
    }
}