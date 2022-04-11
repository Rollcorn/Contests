import java.util.HashMap;
import java.util.HashSet;

/******************************************************************************************
 * Task 141. Linked List Cycle
 * 
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * 
 * There is a cycle in a linked list if there is some node in the list that can be reached
 * again by continuously following the next pointer. Internally, pos is used to denote the 
 * index of the node that tail's next pointer is connected to. Note that pos is not passed 
 * as a parameter.
 * 
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * 
 */

 
 // Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next = null;
    ListNode(int x) {
        val = x;
        next = null;
    }
 }
 public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> nodeSet = new HashMap<>();

        ListNode curreNode = head;

        for ( int i = 0; curreNode != null; ++i ) {
            if ( nodeSet.containsKey(curreNode) ) {
                return true;
            }
            nodeSet.put(curreNode, i );
            curreNode = curreNode.next;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(4);
        // ListNode n5 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        Solution s = new Solution();
        System.out.println( "Has a cycle? " + s.hasCycle(n1) );        
    }
}