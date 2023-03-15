import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	
	static class TreeNode {
		int val;
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
	
	public boolean isBalanced(TreeNode root) {
		return treeHeight(root) != -1;
	}
	
	private int treeHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = treeHeight(root.left);
		int rightHeight = treeHeight(root.right);
		
		if (leftHeight == -1 || rightHeight == -1) {
			return -1;
		}
		
		if (Math.abs(leftHeight - rightHeight) >= 2) {
			return -1;
		}
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	
	public static void main(String[] args) {
		Integer[] a1 = new Integer[]{3, 9, 20, null, null, 15, 7};
		TreeNode t1 = array2tree(a1, 0);
		Integer[] a2 = new Integer[]{1,2,2,3,null,null,3,4,null,null,4};
		TreeNode t2 = array2tree(a2, 0);
		
		Solution s = new Solution();
		
//		System.out.println(s.isBalanced(t1) == true);
		System.out.println(s.isBalanced(t2) == true);
		
	}
	
	private static TreeNode array2tree(Integer[] a1, int index) {
		if (index >= a1.length || a1[index] == null || a1[index] == -1) {
			return null;
		}
		TreeNode node = new TreeNode(a1[index]);
		node.left = array2tree(a1, 2 * index + 1);
		node.right = array2tree(a1, 2 * index + 2);
		return node;
	}
	
	
	private Integer[] tree2array(TreeNode root) {
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
			}
		}
		// Convert the list to an Integer[] array and return it
		return list.toArray(new Integer[0]);
	}
}
