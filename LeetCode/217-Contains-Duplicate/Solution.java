import java.util.HashSet;

/**
 * TASK 217. Contains Duplicate
 * Given an integer array nums, return true if any value appears at least twice in the 
 * array, and return false if every element is distinct.
 *  Related Array Hash Table Sorting
 */


class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numsHashSet = new HashSet<>();
        
        for (Integer elem : nums ) {
            if(numsHashSet.contains(elem)){
                return true;
            } else {
                numsHashSet.add(elem);
            }
        }
        return false;
    }
}