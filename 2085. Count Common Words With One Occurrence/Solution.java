import java.util.HashMap;

/***********************************************************************************************************************
 * 2085. Count Common Words With One Occurrence
 * https://leetcode.com/problems/count-common-words-with-one-occurrence/
 * Given two string arrays words1 and words2, return the number of strings that
 * appear exactly once in each of the two arrays.
 *
 */
public class Solution {

    public int countWords(String[] words1, String[] words2) {
        int res = 0;
        HashMap<Integer, String> resmap = new HashMap<>();
        int[] words1map = new int[words1.length];
        int[] words2map = new int[words2.length];

        for (int i = 0; i != words1.length; i++ ) {
            String s = words1[i];
            Integer hcode = s.hashCode();

            if ( resmap.containsKey(hcode) && ( (resmap.get(hcode) == null) || resmap.get(hcode).equals(s) ) ){
                resmap.put( hcode, null );
                words1map[i] = 0;
            } else {
                resmap.put( hcode, s );
                words1map[i] = 1;
            }
        }

        for ( int i = 0; i != words2.length; i++ ) {
            String s = words1[i];
            Integer hcode = s.hashCode();

            if( )
        }

        return res;
    }
}
