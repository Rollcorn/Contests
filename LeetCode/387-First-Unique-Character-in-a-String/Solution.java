import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a string s, find the first non-repeating character in it and return its index. 
 * If it does not exist, return -1.
 */

class Solution {
    public int firstUniqChar(String s) {

        HashMap<Character, Integer> charTable = new HashMap<>();
        Queue<Integer> singlApearQueue = new LinkedList<>();
        
        int charInd = 0;

        for ( int i = 0; i < s.length(); ++i ) {
            char c = s.charAt(i);
            if ( charTable.containsKey(c) ) {
                charTable.replace( c, charTable.get(c) + 1 );
                if ( s.charAt(charInd) == c && !singlApearQueue.isEmpty() ) {
                    // Пока не найдем в очереди элемент который до текущего момента встречался
                    // только один раз снимаем элементы из очереди
                    while ( !singlApearQueue.isEmpty() && charTable.get( s.charAt(charInd) ) != 1 ){
                        charInd = singlApearQueue.poll();
                    }
                }
            } else {
                charTable.put( c, 1 );
                if ( singlApearQueue.isEmpty() && charTable.get( s.charAt(charInd) ) != 1 ) {
                    charInd = i;
                }
                singlApearQueue.add(i);
            }
        }

        if ( charTable.get( s.charAt(charInd) ) == 1 ) {
            return charInd;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String str1 = "leetcode";
        String str2 = "loveleetcode";
        String str3 = "aabb";
        String str4 = "dddccdbba";

        Solution s = new Solution();
        System.out.println( "Str 1 = " + str1 + " - (" + s.firstUniqChar(str1) + ")" );
        System.out.println( "Str 2 = " + str2 + " - (" + s.firstUniqChar(str2) + ")" );
        System.out.println( "Str 3 = " + str3 + " - (" + s.firstUniqChar(str3) + ")" );
        System.out.println( "Str 4 = " + str4 + " - (" + s.firstUniqChar(str4) + ")" );

    }
}


/*******************************************************************************************
 * Solution 1
 * 
 *       < {символ строки}, {количество таких символов в строке} >
        HashMap<Character, Integer> charTable = new HashMap<>();
        Queue<Integer> singlApearQueue = new LinkedList<>();
        
        int currentInd = 0;
        int charInd = 0;

        for ( Character c : s.toCharArray() ) {
            if ( charTable.containsKey(c) ) {
                charTable.replace( c, charTable.get(c) + 1 );

                if ( s.charAt(charInd) == c && !singlApearQueue.isEmpty() ) {
                    // Пока не найдем в очереди элемент который до текущего момента встречался
                    // только один раз снимаем элементы из очереди
                    while ( !singlApearQueue.isEmpty() && charTable.get( s.charAt(charInd) ) != 1 ){
                        charInd = singlApearQueue.poll();
                    }
                }

            } else {
                charTable.put( c, 1 );
                if ( singlApearQueue.isEmpty() && charTable.get( s.charAt(charInd) ) != 1 ) {
                    charInd = currentInd;
                }
                singlApearQueue.add(currentInd);
            }
            ++currentInd;
        }

        if ( charTable.get( s.charAt(charInd) ) == 1 ) {
            return charInd;
        } else {
            return -1;
        }
 * 
 * 
 * Solution 2 22ms
 * 
 *     public int firstUniqChar(String s) {
        HashMap<Character, Integer> charTable = new HashMap<>();

        for ( int i = 0; i < s.length(); ++i ) {
            charTable.put(s.charAt(i), charTable.getOrDefault(s.charAt(i), 0) + 1);
        }

        for ( int i = 0; i < s.length(); ++i ) {
            if ( charTable.get(s.charAt(i)) == 1 ) {
                return i;
            } 
        }
        return -1;
    }
 * 
 */