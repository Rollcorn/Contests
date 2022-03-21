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

    public int findTarget(int[] nums, int target) {
        int beginArrayIndex = 0;
        int endArrayIndex = nums.length - 1;
        int middleArrayIndex = endArrayIndex / 2;

        while( (endArrayIndex - beginArrayIndex) >= 0 && nums[middleArrayIndex] != target) {
            if( target < nums[beginArrayIndex] || target > nums[endArrayIndex] ) { 
                return -1;
            } 
            
            if ( target > nums[middleArrayIndex] ) {
                beginArrayIndex = middleArrayIndex + 1;
            } else {
                endArrayIndex = middleArrayIndex;
            }

            middleArrayIndex = beginArrayIndex + (endArrayIndex - beginArrayIndex) / 2;
        }            

        if (nums[middleArrayIndex] == target){
            return middleArrayIndex;
        } else {
            return -1;
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] arrIndexes = new int[2];
        int firstIndex = 0;
        int secondIndex = 0;

        

        while( numbers[firstIndex] <= target ){
            secondIndex = findTarget( numbers, target - numbers[firstIndex] );

            if ( secondIndex != -1 && firstIndex != secondIndex ) {
                arrIndexes[0] = firstIndex + 1;
                arrIndexes[1] = secondIndex + 1;
                break;
            } else {
                secondIndex = 0;
                ++firstIndex;
            }
        }
        Arrays.sort(arrIndexes);
        return arrIndexes;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {0,1,0,3,12};
        int[] arr2 = {2,7,11,15};
        int[] arr3 = {2,3,4};
        int[] arr4 = {-1,0};
        int[] arr5 = {1,2,3,4,4,9,56,90};

        Solution s = new Solution();

        printArray(arr1);
        int[] res1 = s.twoSum(arr1, 4);
        printArray(res1);
        
        printArray(arr2);
        int[] res2 = s.twoSum(arr2, 9);
        printArray(res2);

        printArray(arr3);
        int[] res3 = s.twoSum(arr3, 6);
        printArray(res3);

        printArray(arr4);
        int[] res4 = s.twoSum(arr4, -1);
        printArray(res4);

        printArray(arr5);
        int[] res5 = s.twoSum(arr5, 8);
        printArray(res5);
    }

    public static void printArray(int[] arr){
        System.out.print("[");
        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println("]");
    }
}