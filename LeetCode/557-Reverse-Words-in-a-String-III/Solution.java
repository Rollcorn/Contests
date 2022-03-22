class Solution {

    public void reversePartOfArray(char[] s, int begin, int end ) {
        for (int i = 0; i < (1 + (end - begin)/2); i++ ){
            char tempChar = s[begin + i];
            s[begin + i] = s[end - i];
            s[end - i] = tempChar;
        }
    }

    public String reverseWords(String s) {
        char[] charArr = s.toCharArray();
        printArray(charArr);
        int wordBegin = 0;
        int wordEnd = 0;

        for ( int i = 0; i < charArr.length; i++ ){
            if( charArr[i] == ' ' ){
                // System.out.println("word=" + i);
                reversePartOfArray( charArr, wordBegin, wordEnd );
                wordBegin = i + 1;
            } 
            
            wordEnd = i;
            
            if ((i + 1) == charArr.length){
                reversePartOfArray( charArr, wordBegin, wordEnd );
            }

        }
        return new String(charArr);
    }

    public static void main(String[] args) {
        String s1 = "Let's take LeetCode contest";
        String s2 = "God Ding";
        
        Solution s = new Solution();

        System.out.println(s1);
        System.out.println(s.reverseWords(s1));

        System.out.println(s2);
        System.out.println(s.reverseWords(s2));

    }

    public static void printArray(char[] arr){
        System.out.print("[");
        for(char x : arr){
            System.out.print(x);
        }
        System.out.println("]");
    }
}