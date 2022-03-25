import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 500. Keyboard Row
 * Given an array of strings words, return the words that can be typed using 
 * letters of the alphabet on only one row of American keyboard like the image below.
 * 
 */

class Solution {

    public boolean isWordBelongToSet( HashSet<Character> set, String word ){
        for (int i = 1; i < word.length(); ++i ){
            if( !set.contains(word.charAt(i)) ){
                return false;
            }
        }
        return true;
    }

    public String[] findWords(String[] words) {
        ArrayList<String> result = new ArrayList<>();

        HashSet<Character> firstRow = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        HashSet<Character> secondRow = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        HashSet<Character> thirdRow = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));

        for ( String currentWord : words ){
            String currentWordInLowCase = currentWord.toLowerCase();
            Character firstCharInWord = currentWordInLowCase.charAt(0);
            if( ( firstRow.contains(firstCharInWord) && isWordBelongToSet(firstRow, currentWordInLowCase) ) ||
                ( secondRow.contains(firstCharInWord) && isWordBelongToSet(secondRow, currentWordInLowCase) ) ||
                ( thirdRow.contains(firstCharInWord) && isWordBelongToSet(thirdRow, currentWordInLowCase) ) ) {
                    result.add(currentWord);
            }
        }
        return result.toArray(new String[0]);
    }

    public static void printArr(String[] str){
        System.out.print("[");
        for(String w : str ){
            System.out.print(w + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        String[] str1 = {"Hello","Alaska","Dad","Peace"};
        String[] str2 = {"adsdf","sfd"};
        String[] str3 = {"omk"};

        Solution s = new Solution();
        String[] res1 = s.findWords(str1);
        String[] res2 = s.findWords(str2);
        String[] res3 = s.findWords(str3);
        
        printArr(res1);
        printArr(res2);
        printArr(res3);

    }
}