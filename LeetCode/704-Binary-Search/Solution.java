/************************************************************************
 * 704. Binary Search
 * 
 * Given an array of integers nums which is sorted in ascending order, 
 * and an integer target, write a function to search target in nums. 
 * If target exists, then return its index. Otherwise, return -1.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 */

public class Solution {
    public int search(int[] nums, int target) {
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

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8};

        Solution s = new Solution();

        System.out.println("Search -1 - " + s.search(arr1, -1));
        System.out.println("Search 1 - " + s.search(arr1, 1));
        System.out.println("Search 2 - " + s.search(arr1, 2));
        System.out.println("Search 3 - " + s.search(arr1, 3));
        System.out.println("Search 4 - " + s.search(arr1, 4));
        System.out.println("Search 5 - " + s.search(arr1, 5));
        System.out.println("Search 6 - " + s.search(arr1, 6));
        System.out.println("Search 7 - " + s.search(arr1, 7));
        System.out.println("Search 8 - " + s.search(arr1, 8));
        System.out.println("Search 10 - " + s.search(arr1, 10));

    }

}
