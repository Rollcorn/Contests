/**
 * Given a sorted array of distinct integers and a target value, return the 
 * index if the target is found. If not, return the index where it would be 
 * if it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 */


class Solution {
    public int searchInsert(int[] nums, int target) {
        int beginOfArray = 0;
        int endOfArray = nums.length - 1;
        int middleOfArray = endOfArray / 2;

        while ( nums[middleOfArray] != target ) {
            if ( target < nums[beginOfArray] ) {
                return beginOfArray;
            }
            if ( target > nums[endOfArray] ) {
                return (endOfArray + 1);
            }
            if ( target > nums[middleOfArray] ) {
                beginOfArray = middleOfArray + 1;
            } else {
                endOfArray = middleOfArray;
            }
            middleOfArray = beginOfArray + (endOfArray - beginOfArray)/2;
        } 

        return middleOfArray;
    }

    public static void main(String[] args) {
        
    }

}