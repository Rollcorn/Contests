import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/************************************************************************
 * TASK
 * Given two integer arrays nums1 and nums2, return an array of their 
 * intersection. Each element in the result must appear as many times 
 * as it shows in both arrays and you may return the result in any order.
 * 
 * Constraints:
 *  1 <= nums1.length, nums2.length <= 1000
 *  0 <= nums1[i], nums2[i] <= 1000
 * 
 * FOLLOW UP
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that 
 * you cannot load all elements into the memory at once?
 */


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resList = new ArrayList<>();
        // Первый ключ это значение в ячейке, а второе количество 
        // элементов с таким значением в массиве 
        HashMap<Integer, Integer> firstArrHM = new HashMap<>();

        for ( int i = 0; i < nums1.length; ++i ){
            if( !firstArrHM.containsKey(nums1[i]) ){
                firstArrHM.put(nums1[i], 1);
            } else {
                firstArrHM.put(nums1[i], firstArrHM.get(nums1[i]) + 1);
            }
        }

        for ( int i = 0; i < nums2.length; ++i ) {
            if ( firstArrHM.containsKey(nums2[i]) && firstArrHM.get(nums2[i]) != 0 ){
                resList.add(nums2[i]);
                firstArrHM.put(nums2[i], firstArrHM.get(nums2[i]) - 1 );
            }
        }
        int[] resArr = new int[resList.size()];

        int ind = 0;
        for (int i : resList) {
            resArr[ind++] = i;
        }

        return resArr;
    }

    public static void main(String[] args) {
        int[] a1 = {1,2,2,1};
        int[] b1 = {2,2};

        int[] a2 = {4,9,5};
        int[] b2 = {9,4,9,8,4};

        Solution s = new Solution();

        int[] r1 = s.intersect( a1, b1 );
        System.out.println(Arrays.toString(r1));

        int[] r2 = s.intersect( a2,b2 );
        System.out.println(Arrays.toString(r2));

    }
}