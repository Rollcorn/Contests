
/**
 * 500. Keyboard Row
 * Given an array of strings words, return the words that can be typed using 
 * letters of the alphabet on only one row of American keyboard like the image below.
 * 
 */

class Solution {
    String[] stringRow = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};

    public String[] findWords(String[] words) {
        String[] result;

        // Перебираем ряды символов 
        for ( String strRow : stringRow ) {
            char[] charRow = strRow.toString().toCharArray();    
            // Перебираем слова 
            for (String currWordStr : words ) {
                char[] currWordChar = currWordStr.toString().toCharArray();    

                // Ищем в ряду символов все буквы данного слова
                for (int i = 0; i != charRow.length; i++ ){

                }

            }
        }

        return result;
    }
}