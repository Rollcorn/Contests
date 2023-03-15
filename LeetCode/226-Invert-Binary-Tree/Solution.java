import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
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


public class Solution {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode tmp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(tmp);
		return root;
	}
	
	
	public static void main(String[] args) {
		int[] a1 = new int[]{4, 2, 7, 1, 3, 6, 9};
		System.out.println(Arrays.toString(a1));
		TreeNode t1 = array2tree(a1, 0);
		Solution s = new Solution();
		s.invertTree(t1);
		System.out.println(Arrays.toString(tree2array(t1)));
	}
	
	private static TreeNode array2tree(int[] a1, int index) {
		if (index >= a1.length || a1[index] == -1) {
			return null;
		}
		TreeNode node = new TreeNode(a1[index]);
		node.left = array2tree(a1, 2 * index + 1);
		node.right = array2tree(a1, 2 * index + 2);
		return node;
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
			}
		}
		// Convert the list to an Integer[] array and return it
		return list.toArray(new Integer[0]);
	}
	
	
}
