import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int longestPalindrome(String[] words) {
		if(words == null || words.length == 0){
			return 0;
		}
		
		Map<String, Integer> wordsCounter = new HashMap<>();
		for (String word : words) {
			wordsCounter.put(word, wordsCounter.getOrDefault(word, 0) + 1);
		}
		
		int length = 0;
		int hasOdd = 0;
		for (String word : words) {
			String reversWord = new StringBuilder(word).reverse().toString();
			if (word.charAt(0) == word.charAt(1)) {
				if (wordsCounter.get(word) % 2 == 0) {
					hasOdd += wordsCounter.get(word);
				} else if (wordsCounter.get(word) % 2 == 1) {
					if (hasOdd % 2 == 1) {
						hasOdd += wordsCounter.get(word) - 1;
					} else {
						hasOdd += wordsCounter.get(word);
					}
				}
				wordsCounter.put(word, 0);
			}
			if (!wordsCounter.containsKey(reversWord)) {
				wordsCounter.put(word, 0);
				continue;
			}
			if (wordsCounter.containsKey(word) && wordsCounter.get(word) == 0) {
				continue;
			}
			if (!word.equals(reversWord) && wordsCounter.containsKey(reversWord) && wordsCounter.get(reversWord) > 0) {
				length += word.length() * 2;
				wordsCounter.put(word, wordsCounter.get(word) - 1);
				wordsCounter.put(reversWord, wordsCounter.get(reversWord) - 1);
			}
		}
		
		if (hasOdd > 0) {
			length += hasOdd * 2;
		}
		return length;
	}
	
	public static void main(String[] args) {
		String[] a1 = new String[]{"lc", "cl", "gg"};
		String[] a2 = new String[]{"ab", "ty", "yt", "lc", "cl", "ab"};
		String[] a3 = new String[]{"cc", "ll", "xx"};
		String[] a4 = new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"};
		Solution s = new Solution();
		System.out.println(s.longestPalindrome(a1));
		System.out.println(s.longestPalindrome(a2));
		System.out.println(s.longestPalindrome(a3));
		System.out.println(s.longestPalindrome(a4));
		
	}
}
