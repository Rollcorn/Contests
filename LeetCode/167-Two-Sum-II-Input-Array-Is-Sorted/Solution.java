import java.lang.annotation.Target;
import java.util.Arrays;

/**************************************************************
 * Given a 1-indexed array of integers numbers that is already 
 * sorted in non-decreasing order, find two numbers such that 
 * they add up to a specific target number. Let these two 
 * numbers be numbers[index1] and numbers[index2] where 
 * 1 <= index1 < index2 <= numbers.length.
 * 
 * Return the indices of the two numbers, index1 and index2, 
 * added by one as an integer array [index1, index2] of 
 * length 2.
 * 
 * The tests are generated such that there is exactly one 
 * solution. You may not use the same element twice.
 * 
 * Your solution must use only constant extra space.
 */

class Solution {

    public int findTarget(int[] nums, int target, int currIndex ) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int middleArrayIndex;

        while( leftIndex <= rightIndex ) {

            middleArrayIndex = leftIndex + (rightIndex - leftIndex) / 2;

            if ( nums[middleArrayIndex] == target  && (middleArrayIndex != currIndex) ) {
                return middleArrayIndex;
            } 
            if( target < nums[middleArrayIndex] ){
                rightIndex = middleArrayIndex - 1;
            } else {
                leftIndex = middleArrayIndex + 1;
            }
        }
        
        return -1;
    }

    // This solution O(N*logN)
    public int[] twoSum(int[] numbers, int target) {
        int[] arrIndexes = new int[2];
        
        int secondIndex = 0;

        for( int firstIndex = 0; firstIndex < numbers.length; firstIndex++ ){
            System.out.println("try to find = " + (target - numbers[firstIndex]) );
            secondIndex = findTarget( numbers, target - numbers[firstIndex], firstIndex );

            if ( secondIndex + 1 != 0   ) {
                arrIndexes[0] = firstIndex + 1;
                arrIndexes[1] = secondIndex + 1;
                return arrIndexes;
            } 
        }
        return null;
    }

    /* This solution O(N) */
    // public int[] twoSum(int[] nums, int target) {
    //     int i=0;
    //     int j=nums.length-1;
    //     while(i<j){
    //         int sum=nums[i]+nums[j];
    //         if(sum==target){
    //             int[] ar = {++i,++j};
    //             return ar;
    //         }
    //         if(sum>target){
    //             j--;
    //         }
    //         else{
    //             i++;
    //         }

    //     }
    //     return null;
    // }
    
    public static void main(String[] args) {
        int[] arr1 = {0,1,0,3,12};
        int[] arr2 = {2,7,11,15};
        int[] arr3 = {2,3,4};
        int[] arr4 = {-1,0};
        int[] arr5 = {1,2,3,4,4,9,56,90};
        int[] arr6 = {-1,-1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

        Solution s = new Solution();

        printArray(arr1);
        int[] res1 = s.twoSum(arr1, 4);
        printArray(res1);
        System.out.println();

        printArray(arr2);
        int[] res2 = s.twoSum(arr2, 9);
        printArray(res2);
        System.out.println();

        printArray(arr3);
        int[] res3 = s.twoSum(arr3, 6);
        printArray(res3);
        System.out.println();

        printArray(arr4);
        int[] res4 = s.twoSum(arr4, -1);
        printArray(res4);
        System.out.println();

        printArray(arr5);
        int[] res5 = s.twoSum(arr5, 8);
        printArray(res5);
        System.out.println();

        printArray(arr6);
        int[] res6 = s.twoSum(arr6, -2);
        printArray(res6);
    }

    public static void printArray(int[] arr){
        System.out.print("[");
        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println("]");
    }
}