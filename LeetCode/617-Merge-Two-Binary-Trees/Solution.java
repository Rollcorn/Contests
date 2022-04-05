/**
 *  You are given two binary trees root1 and root2.
 * 
 *   Imagine that when you put one of them to cover the other, some nodes of
 * the two trees are overlapped while the others are not. You need to merge 
 * the two trees into a new binary tree. The merge rule is that if two nodes 
 * overlap, then sum node values up as the new value of the merged node. 
 * Otherwise, the NOT null node will be used as the node of the new tree.
 * 
 * Return the merged tree.
 * 
 * Note: The merging process must start from the root nodes of both trees.
 * 
 * Constraints:
 *  The number of nodes in both trees is in the range [0, 2000].
 *  -104 <= Node.val <= 104
 */



class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
    }
}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}