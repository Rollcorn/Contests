import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * TASK 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two 
 * numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may not 
 * use the same element twice.
 * 
 * You can return the answer in any order.
 */


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int leftIndex = 0;
        int[] result = new int[2];

        HashMap<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; ++i ){
            numsMap.put( nums[i], i );
        }

        while ( leftIndex != nums.length ){

            int desireOp = 0;
            desireOp = target - nums[leftIndex]; 
            
            if ( numsMap.get(desireOp) != null && numsMap.get(desireOp) != leftIndex ){
                result[0] = numsMap.get(desireOp);
                result[1] = leftIndex;
                Arrays.sort(result);
                return result;
            }
            ++leftIndex;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{2,7,11,15};
        int[] a2 = new int[]{3,2,4};
        int[] a3 = new int[]{3,3};
        
        Solution s = new Solution();

        System.out.println( Arrays.toString(s.twoSum(a1, 9)) );
        System.out.println( Arrays.toString(s.twoSum(a2, 6)));
        System.out.println( Arrays.toString(s.twoSum(a3, 6)));


    }
}