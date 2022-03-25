import java.sql.Array;
import java.util.*;

/***********************************************************************************************************************
 * 2085. Count Common Words With One Occurrence
 * https://leetcode.com/problems/count-common-words-with-one-occurrence/
 * Given two string arrays words1 and words2, return the number of strings that
 * appear exactly once in each of the two arrays.
 *
 */
public class Solution {

    public int countWords(String[] words1, String[] words2) {

        Map<String, Boolean> uniqWords1 =  new TreeMap<>();
        Map<String, Boolean> uniqWords2 =  new TreeMap<>();
        ArrayList<String> resWords = new ArrayList<>();

        // 1. Найти пересечение двух массивов

        for ( String word : words1 ) {
            if ( uniqWords1.containsKey(word) ) {
                uniqWords1.put( word, false );
                continue;
            }
            uniqWords1.put(word, true);

        }

        for ( String word : words2 ) {
            if ( uniqWords2.containsKey(word) ) {
                uniqWords2.put( word, false );
                continue;
            }
            uniqWords2.put(word, true);

        }

        uniqWords1.forEach((s, aBoolean) -> {
            if ( aBoolean && uniqWords2.containsKey(s) && uniqWords2.get(s) ){
                resWords.add(s);
            }
        });


        // 2. Убедиться, что эти слова уникальны в своих массивах

        return resWords.size();
    }

    public static void main(String[] args) {
        String[] s1 = new String[]{"leetcode","is","amazing","as","is"};
        String[] s2 = new String[]{"amazing","leetcode","is"};
        Solution sol = new Solution();
        System.out.println(sol.countWords(s1, s2));

        String[] s3 = new String[]{"a","ab"};
        String[] s4 = new String[]{"a","a","a","ab"};
        Solution sol2 = new Solution();
        System.out.println(sol2.countWords(s3, s4));

    }

}


