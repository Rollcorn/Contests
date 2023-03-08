import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		Character[] result = new Character[Math.max(num1.length() * num2.length(), num1.length() + num2.length())];
		
		for (int i = num1.length() - 1; i >= 0; --i) {
			int firstNum = Character.getNumericValue(num1.charAt(i));
			for (int j = num2.length() - 1; j >= 0; --j) {
				int secondNum = Character.getNumericValue(num2.charAt(j));
				var currentResult = String.valueOf(firstNum * secondNum).toCharArray();
//				System.out.println("========= Try to sum to result: " + Arrays.toString(result) + " =========");
//				System.out.println(firstNum + " * " + secondNum + " = " + Arrays.toString(currentResult));
				sumResult(result, num1.length() - i - 1 + num2.length() - j - 1, currentResult);
			}
		}
		List<Character> resultList = Arrays.asList(result);
		Collections.reverse(resultList);
		StringBuilder sb = new StringBuilder();
		resultList.stream().filter(Objects::nonNull).forEach(sb::append);
		return sb.toString();
	}

	private static void sumResult(Character[] target, int startIndex, char[] source) {
//		System.out.println("start at [" + startIndex + "] from source " + Arrays.toString(source));
		for (int k = source.length - 1; k >= 0; --k) {
			if (target[startIndex +  source.length - k - 1] != null) {
				int current = Character.getNumericValue(source[k])
						              + Character.getNumericValue(target[startIndex + source.length - k - 1]);
//				System.out.println("Update sum " + current);
				if (current > 9) {
					target[startIndex + source.length - k - 1] = (char) ((current % 10) + '0');
//					System.out.println("Update target " + Arrays.toString(target));
					sumResult(target, startIndex + source.length - k - 1 + 1, String.valueOf(current / 10).toCharArray());
				} else {
//					System.out.println("Insert " + current + " at [" + (startIndex + source.length - k - 1) + "]");
					target[startIndex + source.length - k - 1] = (char) (current + '0');
				}
			} else {
//				System.out.println("Insert " + source[k] + " at [" + (startIndex + source.length - k - 1) + "]");
				target[startIndex + source.length - k - 1] = source[k];
			}
		}
	}
	
	
	public static void main(String[] args) {
		MultiplyStrings multiplyStrings = new MultiplyStrings();
//		System.out.println(multiplyStrings.multiply("12345", "12345"));
//		System.out.println(multiplyStrings.multiply("123", "456"));
		System.out.println(multiplyStrings.multiply("4", "2"));
		System.out.println(multiplyStrings.multiply("9", "9"));
		System.out.println(multiplyStrings.multiply("9", "0"));
	}
}
