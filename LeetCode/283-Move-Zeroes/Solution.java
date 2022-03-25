/******************************************************************
 * TASK:
 * Given an integer array nums, move all 0's to the end of it while 
 * maintaining the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of 
 * the array.
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int[] nonZeroArrays = new int[nums.length];
        
        int currentIndex = 0;
        for(int i = 0; i != nums.length; i++ ){
            if(nums[i] != 0){
                nonZeroArrays[currentIndex] = nums[i];
                currentIndex++;
            }
        }
        
        for(int i = 0; i != nums.length; i++ ){
            nums[i] = nonZeroArrays[i];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {0,1,0,3,12};
        Solution s = new Solution();

        printArray(arr1);
        s.moveZeroes(arr1);
        printArray(arr1);


    }

    public static void printArray(int[] arr){
        System.out.print("[");
        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println("]");
    }
}