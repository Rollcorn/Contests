import java.util.Stack;

/**
 * Task 20. Valid Parentheses
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the 
 * input string is valid.
 * 
 * An input string is valid if:
 *     - Open brackets must be closed by the same type of brackets.
 *     - Open brackets must be closed in the correct order.
 */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();

        for ( int i = 0; i < s.length(); ++i ) {
            Character curChar = s.charAt(i);
            if ( charStack.isEmpty() ) {
                charStack.push(curChar);
                continue;
            } 
            Character stackPeak = charStack.peek();

            if ( stackPeak == '(' && curChar == ')' ||  
                 stackPeak == '[' && curChar == ']' ||
                 stackPeak == '{' && curChar == '}' ) 
            {
                charStack.pop();
            } else {
                charStack.push(curChar);
            }
        }
        return charStack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        
        Solution s = new Solution();

        System.out.println(s.isValid(s1));        
        System.out.println(s.isValid(s2));
        System.out.println(s.isValid(s3));
    }
}