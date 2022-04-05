import java.sql.Array;
import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two 
 * integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead be stored inside 
 * the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements 
 * denote the elements that should be merged, and the last n elements are set to 0 and should be 
 * ignored. nums2 has a length of n.
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int firstArrIndex = m - 1;
        int secondArrIndex = n - 1;
        int currentIndex = m + n - 1;

        while ( firstArrIndex >= 0 && secondArrIndex >= 0 ) {
            if ( nums1[firstArrIndex] >= nums2[secondArrIndex] ) {
                nums1[currentIndex] = nums1[firstArrIndex--]; 
            } else {
                nums1[currentIndex] = nums2[secondArrIndex--];
            }
            currentIndex--;
        }


        while(secondArrIndex >= 0){
            nums1[currentIndex--] =  nums2[secondArrIndex--];
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1,2,3,0,0,0};
        int m1 = 3;
        int[] b1 = {2,5,6};
        int n1 = 3;

        int[] a2 = {1};
        int m2 = 1;
        int[] b2 = {};
        int n2 = 0;

        int[] a3 = {0};
        int m3 = 0;
        int[] b3 = {1};
        int n3 = 1;

        Solution s = new Solution();

        s.merge(a1, m1, b1, n1);
        System.out.println(Arrays.toString(a1));

        s.merge(a2, m2, b2, n2);
        System.out.println(Arrays.toString(a2));

        s.merge(a3, m3, b3, n3);
        System.out.println(Arrays.toString(a3));

    }
}