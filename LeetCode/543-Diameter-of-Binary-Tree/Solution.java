import java.util.ArrayList;
import java.util.Deque;
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
	
	int result = -1;
	
	public int diameterOfBinaryTree(TreeNode root) {
		treeHeight(root);
		return result;
	}
	
	private int treeHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = treeHeight(root.left);
		int rightHeight = treeHeight(root.right);
		result = Math.max(leftHeight + rightHeight, result);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	
	public static void main(String[] args) {
		Integer[] a1 = new Integer[]{1, 2, 3, 4, 5};
//		TreeNode t1 = array2tree(a1);
		
		Integer[] a2 = new Integer[]{1, 2};
//		TreeNode t2 = array2tree(a2);
		
		Integer[] a3 = new Integer[]{
				4,
				-7, -3,
				null, null, -9, -3,
				9, -7, -4, null, 6, null, -6, -6,
				null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2};
		TreeNode t3 = array2tree(a3);
		removeEmptyVal(t3);
		
		Solution s = new Solution();

//		System.out.println("Diameter Of Binary Tree: " + s.diameterOfBinaryTree(t1));
//		System.out.println("Diameter Of Binary Tree: " + s.diameterOfBinaryTree(t2));
		System.out.println("Diameter Of Binary Tree: " + s.diameterOfBinaryTree(t3));
		
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
