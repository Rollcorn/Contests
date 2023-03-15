import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
	
	public int pathSum(TreeNode root, int targetSum) {
		// Key - is passed summ,
		// Value - is the node status: 1 - this sum belong to current path, 0 - sum not belong to current path
		Map<Long, Integer> prefixSum = new HashMap<>();
		prefixSum.put(0L, 1); // demmy node before root
		return dfs(root, targetSum, 0L, prefixSum);
	}
	
	private int dfs(TreeNode root, int targetSum, Long currSum, Map<Long, Integer> passedNodes) {
		if (root == null) {
			return 0;
		}
		
		currSum += root.val;
		int count = passedNodes.getOrDefault(currSum - targetSum, 0);
		
		// when step in current node put current sum in prefix and assign status 1 for follow dfs its childrens
		passedNodes.put(currSum, passedNodes.getOrDefault(currSum, 0) + 1);
		
		count += dfs(root.left, targetSum, currSum, passedNodes);
		count += dfs(root.right, targetSum, currSum, passedNodes);
		
		// when current node childrens are passed - change status to 0 for avoid trying to use this node for not suitable paths
		passedNodes.put(currSum, passedNodes.get(currSum) - 1);
		
		return count;
	}
	
	public static void main(String[] args) {
		int n1 = 8;
		Integer[] a1 = new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
		TreeNode t1 = array2tree(a1);
		removeEmptyVal(t1);
		
		int n2 = 0;
		Integer[] a2 = new Integer[]{1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000};
		TreeNode t2 = array2tree(a2);
		removeEmptyVal(t2);
		
		Integer[] a3 = new Integer[]{4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6,
				5, null, 9, null, null, -1, -4, null, null, null, -2};
		TreeNode t3 = array2tree(a3);
		removeEmptyVal(t3);
		
		Solution s = new Solution();
		
//		System.out.println("Count sum for target [" + n1 + "]: " + s.pathSum(t1, n1));
		System.out.println("Count sum for target [" + n2 + "]: " + s.pathSum(t2, n2));
//		System.out.println("Diameter Of Binary Tree: " + s.pathSum(t3));
		
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
}
