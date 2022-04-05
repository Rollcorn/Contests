import java.util.Arrays;

/**
 * You are given an array prices where prices[i] is the price of 
 * a given stock on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one 
 * stock and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If 
 * you cannot achieve any profit, return 0.
 * 
 */


class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int todayProfit;

        int currMin = Integer.MAX_VALUE;


        for ( int i : prices ) {
            if (i < currMin ){
                currMin = i;
            }
            todayProfit = i - currMin;
            maxProfit = Math.max(todayProfit, maxProfit);
        }

        return maxProfit;
    }
    
        public static void main(String[] args) {
        int[] a1 = {7,1,5,3,6,4};
        System.out.println(Arrays.toString(a1));

        int[] a2 = {7,6,4,3,1};


        Solution s = new Solution();

        int r1 = s.maxProfit(a1);
        System.out.println("1) " + r1);
       
        System.out.println(Arrays.toString(a2));
        int r2 = s.maxProfit(a2);
        System.out.println("2) " + r2);

    }
}