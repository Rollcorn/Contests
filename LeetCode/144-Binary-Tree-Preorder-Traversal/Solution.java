import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Task Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */ 
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


class Solution {
    public List<Integer> preorderTraversal( TreeNode root ) {
        List<Integer> mList = new LinkedList<>();
        Deque<TreeNode> mDeque = new LinkedList<>();
        mDeque.addLast(root);

        while ( !mDeque.isEmpty() ) {
            TreeNode tempNode = mDeque.pollFirst();
            if (tempNode == null ) {
                continue;
            } else {
                mList.add(tempNode.val);
                mDeque.addLast(tempNode.left);
                mDeque.addLast(tempNode.right);
            }
        }
        return mList;
    }


    public static void main(String[] args) {
        
    }

}