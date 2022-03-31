/**
 * Task 53. Maximum Subarray
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one 
 * number) which has the largest sum and return its sum.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * Constraints:
 *  1 <= nums.length <= 105
 *  -104 <= nums[i] <= 104
 * 
 * Related
 * Array, Divide and Conquer, Dynamic Programming
 */


class Solution {
    // Its DP algo O(n)
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = 0;

        for( int i = 0; i < nums.length; ++i ){
            if (i == 0 ){
                currentSum = nums[i];
                maxSum = nums[i];
            } else {
                currentSum = Math.max(nums[i], currentSum + nums[i] );
                maxSum = Math.max(maxSum, currentSum );
            }
        } 
        return maxSum;

    // TODO DnC Algo

    }

    public static void main(String[] args) {
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {1};
        int[] nums3 = {5,4,-1,7,8};
    
        Solution s = new Solution();

        System.out.println("Max sum 1 = " + s.maxSubArray(nums1));
        System.out.println("Max sum 2 = " + s.maxSubArray(nums2));
        System.out.println("Max sum 3 = " + s.maxSubArray(nums3));
    
    }
}