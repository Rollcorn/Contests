import java.util.HashMap;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
 * typically using all the original letters exactly once.
 * 
 */

 // !! Через HashMap 15ms через массив 5ms !!
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charArr = new int [26];

        if ( s.length() != t.length() ){
            return false;
        }

        // HashMap<Character, Integer> charMap = new HashMap<>();
        for ( int i = 0; i < t.length(); ++i ) {
        // for ( Character c : s.toCharArray() ) {
            char c = t.charAt(i);
            charArr[ c - 'a']++;
            // charMap.put( c, charMap.getOrDefault(c, 0) + 1);
        }

        for ( int i = 0; i < s.length(); ++i ) {
            char c = s.charAt(i);
            // if ( !charMap.containsKey(c) || charMap.get(c) == 0 ) {
            //     return false;
            // } 
            // charMap.put( c, charMap.get(c) - 1 );
                if (charArr[c - 'a'] == 0 ) {
                    return false;
                }
                charArr[c - 'a']--;

        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram", t1 = "nagaram";
        String s2 = "rat", t2 = "car";

        Solution s = new Solution();
        System.out.println("S1 " + s1 + "T1 " + t1 + " = " + s.isAnagram(s1, t1) );
        System.out.println("S2 " + s2 + "T2 " + t2 + " = " + s.isAnagram(s2, t2) );

    }
}