import java.util.HashMap;

/**
 * TASK
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed from 
 * magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 */

class Solution {
    public boolean canConstruct( String ransomNote, String magazine ) {
        HashMap<Character, Integer> map = new HashMap<>();

        for ( int i = 0; i < magazine.length(); ++i ) {
            char curChar = magazine.charAt(i);
            map.put( curChar, map.getOrDefault(curChar, 0) + 1 );
        }

        for ( int i = 0; i < ransomNote.length(); ++i ) {
            char curChar = ransomNote.charAt(i);

            if ( map.containsKey(curChar) && map.get(curChar) >= 1 ){
                map.put(curChar, map.get(curChar) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

/*************************************************************************
 * Another solution but 10x faster (3ms and 41.8MB)
 *************************************************************************
    int[] table = new int[26];
        int ranLen = ransomNote.length();
        int magLen = magazine.length();
        for ( int i = 0; i < magLen; ++i ) {
            char c = magazine.charAt(i);
            table[c - 'a']++;
        }
        for ( int i = 0; i < ranLen; ++i ) {
            char c = ransomNote.charAt(i);
            if (--table[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
 */
    public static void main(String[] args) {
        String ransomNote1 = "a",  magazine1 = "b";
        String ransomNote2 = "aa", magazine2 = "ab";
        String ransomNote3 = "aa", magazine3 = "aab";

        Solution s = new Solution();

        System.out.println( "1)" + ransomNote1 + "-" + magazine1 +" = " + s.canConstruct(ransomNote1, magazine1));
        System.out.println( "2)" + ransomNote2 + "-" + magazine2 +" = " + s.canConstruct(ransomNote2, magazine2));
        System.out.println( "3)" + ransomNote3 + "-" + magazine3 +" = " + s.canConstruct(ransomNote3, magazine3));

        
    }
}   