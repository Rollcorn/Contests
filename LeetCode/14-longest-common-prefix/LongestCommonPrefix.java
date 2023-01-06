// Runtime 0 ms - Beats 100%
// Memory 42.4 MB -Beats 30.28%
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		for (int i = 1; i < strs.length; ++i) {
			while(strs[i].indexOf(prefix) != 0){
				prefix = prefix.substring(0, prefix.length() -1);
				if(prefix.isEmpty()) return "";
			}
		}
		return prefix;
	}
	
	public static void main(String[] args) {
		String[] s1 = {"flower", "flow", "flight"};
		String[] s2 = {"dog", "racecar", "car"};
		String[] s3 = {"a"};
		String[] s4 = {"ab", "a"};
		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
		System.out.println(longestCommonPrefix.longestCommonPrefix(s1));
		System.out.println(longestCommonPrefix.longestCommonPrefix(s2));
		System.out.println(longestCommonPrefix.longestCommonPrefix(s3));
		System.out.println(longestCommonPrefix.longestCommonPrefix(s4));
	}
}
