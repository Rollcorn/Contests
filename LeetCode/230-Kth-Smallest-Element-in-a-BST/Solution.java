import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
	
	int currentNum = 0;
	
	// Constraints: 1 <= k <= n <= 10^4
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		TreeNode current = root;
		while (true) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			if (stack.isEmpty()) {
				return 0;
			}
			current = stack.pop();
			k--;
			
			if (k == 0) {
				return current.val;
			}
			current = current.right;
		}
	}
	
	public static void main(String[] args) {
		Integer[] a1 = new Integer[]{3, 1, 4, null, 2};
		int k1 = 1;
		Integer[] a2 = new Integer[]{5, 3, 6, 2, 4, null, null, 1};
		int k2 = 3;
		TreeNode t1 = array2tree(a1);
		TreeNode t2 = array2tree(a2);
		
		Solution s = new Solution();
		
		System.out.println(s.kthSmallest(t1, k1));
		System.out.println(s.kthSmallest(t2, k2));
	}
	
	private static TreeNode array2tree(Integer[] a1) {
		
		TreeNode root = new TreeNode();
		Deque<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		for (int i = 0; i < a1.length; i++) {
			TreeNode tmp = queue.pollFirst();
			if (a1[i] != null) {
				tmp.val = a1[i];
				tmp.left = new TreeNode();
				tmp.right = new TreeNode();
				queue.add(tmp.left);
				queue.add(tmp.right);
			}
		}
		removeEmptyVal(root);
		return root;
	}
	
	static private void removeEmptyVal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node != null) {
				if (node.left.val == null) {
					node.left = null;
				} else {
					queue.offer(node.left);
				}
				if (node.right.val == null) {
					node.right = null;
				} else {
					queue.offer(node.right);
				}
			}
		}
	}
}
