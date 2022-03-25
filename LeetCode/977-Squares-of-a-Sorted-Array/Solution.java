import java.lang.reflect.Array;
import java.util.Arrays;

/************************************************************************
 * Given an integer array nums sorted in non-decreasing order, return an 
 * array of the squares of each number sorted in non-decreasing order.
 * 
 */
/**
 * Эта задача является объединением двух задач:
 * - 278-First-Bad-Version
 * - 35-Search-Insert-Position
 * Перестановке подлежат только числа <0, соответственно в первую очередь 
 * необходимо найти границу - индекс в котором меняется знак в массиве, а
 * после выполнить сортировку вставками
 */
class Solution {

    public int firstPositiveIndex(int[] nums){
        int beginArrayIndex = 0;
        int endOfArrayIndex = nums.length - 1;
        int middleArrayIndex = endOfArrayIndex / 2;

        while( (endOfArrayIndex - beginArrayIndex) >= 1 ) {
            if ( nums[middleArrayIndex] >= 0 ) {
                endOfArrayIndex = middleArrayIndex;
            } else {
                beginArrayIndex = middleArrayIndex + 1;
            }
            middleArrayIndex = beginArrayIndex + (endOfArrayIndex - beginArrayIndex) / 2;
        }            

        return beginArrayIndex;
    }

    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int endOfArray = nums.length - 1;
        int firstPositiveElem = firstPositiveIndex(nums);
        int lastNegativeElem = firstPositiveElem - 1;
        int currentIndex = 0;

        while( lastNegativeElem >= 0 && firstPositiveElem <= endOfArray ) {
            if( Math.abs(nums[lastNegativeElem]) < nums[firstPositiveElem] ) {
                res[currentIndex] = (int) Math.pow( nums[lastNegativeElem], 2 );
                lastNegativeElem--;
            } else if ( Math.abs(nums[lastNegativeElem]) == nums[firstPositiveElem] ){
                res[currentIndex] = (int) Math.pow( nums[lastNegativeElem], 2 );
                currentIndex++;
                lastNegativeElem--;
                res[currentIndex] = (int) Math.pow( nums[firstPositiveElem], 2 );
                firstPositiveElem++;
            } else {
                res[currentIndex] = (int) Math.pow( nums[firstPositiveElem], 2 );
                firstPositiveElem++;
            }
            currentIndex++;
        }

        if ( lastNegativeElem < 0 ){
            while( firstPositiveElem <= endOfArray ) {
                res[currentIndex] = (int) Math.pow( nums[firstPositiveElem], 2 );
                currentIndex++;
                firstPositiveElem++;
            }
        } else {
            while( lastNegativeElem >= 0 ) {
                res[currentIndex] = (int) Math.pow( nums[lastNegativeElem], 2 );
                currentIndex++;
                lastNegativeElem--;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        int[] array1 = { -4,-1,0,3,10 };
        int[] array2 = {1};
        Solution s = new Solution();

        System.out.println(s.firstPositiveIndex(array2));
        int[] res = s.sortedSquares(array2);
        System.out.print("[");
        for (int x : res ){
            System.out.print(x + ", ");
        }
        System.out.println("]");
    }
}