import java.util.HashMap;
import java.util.HashSet;

/**********************************************************
 * Given two strings s1 and s2, return true if s2 contains 
 * a permutation of s1, or false otherwise.
 * 
 * In other words, return true if one of s1's permutations 
 * is the substring of s2.
 */

class Solution {

    private boolean isEqualArrays( int[] arr1, int[] arr2 ){
        for ( int i = 0; i < arr1.length; ++i ){
            if( arr1[i] != arr2[i] ){
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {

        int[] s1ArrOfCharFreqIn = new int[26];
        
        for ( int i = 0; i < s1.length(); ++i ){
            // [currChar - 'a'] - делаем поправку текщего элемента на смещение первого символа( т.е. 'a')
            // таким  образом каждая ячейка массива соответстует определенному символу в алфавите 
            s1ArrOfCharFreqIn[s1.charAt(i) - 'a'] += 1;  
        }

        int leftStrIndex = 0;
        int rightStrIndex = 0;
        int[] s2ArrOfCharFreqIn = new int[26];

        while ( rightStrIndex < s2.length() ){
            s2ArrOfCharFreqIn[s2.charAt(rightStrIndex) - 'a'] += 1;  
            
            pringArr(s1ArrOfCharFreqIn);
            pringArr(s2ArrOfCharFreqIn);
            
            if( rightStrIndex - leftStrIndex + 1 == s1.length() &&
                    isEqualArrays(s1ArrOfCharFreqIn, s2ArrOfCharFreqIn) ){
                    return true;
            }

            if( rightStrIndex - leftStrIndex + 1 < s1.length() ){
                rightStrIndex += 1;
            } else {
                s2ArrOfCharFreqIn[s2.charAt(leftStrIndex) - 'a'] -= 1;
                rightStrIndex += 1;
                leftStrIndex += 1;
            }
            System.out.println();
        }
        return false;
    }

    public void pringArr( int[] arr ){
        System.out.print("[");
        for (int i  : arr) {
            System.out.print(i + " ");
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        String str1 = "ab";
        String str2 = "eidbaooo";
        String str3 = "ab";
        String str4 = "eidboaoo";

        Solution s = new Solution();

        System.out.println("1: " + str1 + " : " + str2 + " " + s.checkInclusion(str1, str2) );
        System.out.println("2: " + str3 + " : " + str4 + " " + s.checkInclusion(str3, str4) );

    }
}