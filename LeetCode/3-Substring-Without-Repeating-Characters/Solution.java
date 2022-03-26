import java.util.HashSet;

/******************************************************************************
 * TASK:
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/ 
 */


class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> stringChars = new HashSet<>();
        int longestSubstring = 0;
        int currLongestSubstring = 0;
        // Add two pointers!!!!
        int leftIndex = 0;
        int rightIndex = 0;
        
        while ( rightIndex < s.length() ){
            if( stringChars.contains(s.charAt(rightIndex)) ){
                stringChars.remove(s.charAt(leftIndex));
                ++leftIndex;
            } else {
                stringChars.add(s.charAt(rightIndex));
                ++rightIndex;
            }
            currLongestSubstring = rightIndex - leftIndex;
            longestSubstring = Math.max( currLongestSubstring, longestSubstring);
        }

        return longestSubstring;
    }

    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "bbbbb";    
        String str3 = "pwwkew";
        String str4 = "dvdf";

        Solution s = new Solution();
        System.out.println("str1 max substring len = " + s.lengthOfLongestSubstring(str1));
        System.out.println("str2 max substring len = " + s.lengthOfLongestSubstring(str2));
        System.out.println("str3 max substring len = " + s.lengthOfLongestSubstring(str3));
        System.out.println("str4 max substring len = " + s.lengthOfLongestSubstring(str4));

    }
}