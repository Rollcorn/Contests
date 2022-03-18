/**
 * TASK:
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 */

 /**
  * The solution can be improved - extract reversal code into the function 
  */
class Solution {
    public void rotate(int[] nums, int k) {
        int arrSize = nums.length;

        if(arrSize <= 1 || k == 0 ){
            return;
        }

        int rightIndex = arrSize - 1;
        int tempElem;
        int numRotates = k % nums.length;

        // Разворот массива за N/2
        for ( int currentIndex = 0; currentIndex != arrSize / 2; currentIndex++, rightIndex--) {
            tempElem = nums[currentIndex];
            nums[currentIndex] = nums[rightIndex];
            nums[rightIndex] = tempElem;
        }

        // Разворот левой части массива
        rightIndex = numRotates - 1;
        for ( int currentIndex = 0; currentIndex < numRotates/2; currentIndex++, rightIndex--) {
            tempElem = nums[currentIndex];
            nums[currentIndex] = nums[rightIndex];
            nums[rightIndex] = tempElem;
        }

        // Разворот правой части массива
        rightIndex = arrSize - 1;
        for ( int currentIndex = numRotates; currentIndex < (((arrSize-numRotates)/ 2) + numRotates); currentIndex++, rightIndex--) {
            tempElem = nums[currentIndex];
            nums[currentIndex] = nums[rightIndex];
            nums[rightIndex] = tempElem;
        }
    }

    public static void main(String[] args) {
        int[] array1 = { 1,2,3,4,5,6,7 };
        int[] array2 = { 1};
        int[] array3 = { };
        int[] array4 = {1, 2 };

        printArray(array1);

        Solution s = new Solution();
        
        s.rotate(array1, 5);
        printArray(array1);

        s.rotate(array2, 3);
        printArray(array2);

        s.rotate(array3, 3);
        printArray(array3);

        s.rotate(array4, 3);
        printArray(array4);
    }

    public static void printArray(int[] arr){
        System.out.print("[");
        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println("]");
    }
}