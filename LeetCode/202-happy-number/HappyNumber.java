//  A happy number is a number defined by the following process:
//		Starting with any positive integer, replace the number by the sum of the squares of its digits.
//		Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//		Those numbers for which this process ends in 1 are happy.

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

// Runtime 1 ms - Beats 95.61%
// Memory 39.2 MB - Beats 93.89%
public class HappyNumber {
	
	
	public static boolean isHappy(int number) {
		Set<Integer> numbers = new HashSet<>();
		while (numbers.add(number)) {
			int copy = number;
			number = 0;
			while (copy > 0) {
				int rem = copy % 10;
				number += Math.pow(rem, 2);
				copy = copy / 10;
			}
			if (number == 1) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Assert.assertTrue(HappyNumber.isHappy(19));
		Assert.assertFalse(HappyNumber.isHappy(2));
	}
}
