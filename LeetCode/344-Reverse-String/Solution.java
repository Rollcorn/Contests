/**************************************************************************************************
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * 
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */

class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++ ){
            char tempChar = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tempChar;
        }
    }

    public static void main(String[] args) {
        
    }
}
