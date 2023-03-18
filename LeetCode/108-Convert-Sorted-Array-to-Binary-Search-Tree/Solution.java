import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	static class TreeNode {
		Integer val;
		TreeNode left;
		TreeNode right;
		
		TreeNode() {
		}
		
		TreeNode(int val) {
			this.val = val;
		}
		
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		int middle = nums.length / 2;
		if (nums.length == 1) {
			return new TreeNode(nums[middle]);
		}
		TreeNode root = new TreeNode(nums[middle], sortedArrayToBST(Arrays.copyOfRange(nums, 0, middle)),
		                             sortedArrayToBST(Arrays.copyOfRange(nums, middle + 1, nums.length)));
		return root;
	}
	
	private static Integer[] tree2array(TreeNode root) {
		if (root == null) {
			return new Integer[0];
		}
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node != null) {
				list.add(node.val);
				queue.offer(node.left);
				queue.offer(node.right);
			} else {
				list.add(null);
			}
		}
		// Convert the list to an Integer[] array and return it
		return list.toArray(new Integer[0]);
	}
	
	public static void main(String[] args) {
		int[] a1 = new int[]{-10, -3, 0, 5, 9};
		int[] a2 = new int[]{1,3};
		Solution s = new Solution();
		TreeNode t1 = s.sortedArrayToBST(a1);
		System.out.println(Arrays.toString(tree2array(t1)));
		
//		TreeNode t2 = s.sortedArrayToBST(a2);
//		System.out.println(Arrays.toString(tree2array(t2)));
	
	}
}
