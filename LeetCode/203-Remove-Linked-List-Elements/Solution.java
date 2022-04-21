/**
 * TASK 203. Remove Linked List Elements
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has 
 * Node.val == val, and return the new head.
 * 
 * */

//  Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

 public class Solution {

//  1 Var. time O(N) space O(1)
    public ListNode removeElements(ListNode head, int val) {
        ListNode curNode = head;
        if (head == null) {
            return null;
        }
        while (curNode != null ) {
            if ( curNode.val == val ) {
                if ( head == curNode ) {
                    head = curNode.next;
                }
                curNode = curNode.next;
            } else
            if ( curNode.next != null && curNode.next.val == val ) {

                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }
        return head;
    }


    /** 2 Var. Recursive. time O(N) space O(N)
     *  public ListNode removeElements(ListNode head, int val) {
     *      if (head == null) return null;
     *      head.next = removeElements(head.next, val);
     *      return head.val == val ? head.next : head;
     *  }
     * 
     */

    public static void printList(ListNode head){
        ListNode curNode = head;
        System.out.print("(");
        while ( curNode != null ) {
            System.out.print(curNode.val);
            if ( curNode.next != null ) {
                System.out.print(") --> (");
            }
            curNode = curNode.next;
        }
        System.out.print(")");
        System.out.println();
    }

    public static void main(String[] args) {
//  [1]
        // ListNode n1 = new ListNode(1);
        // ListNode n2 = new ListNode(2);
        // ListNode n3 = new ListNode(6);
        // ListNode n4 = new ListNode(3);
        // ListNode n5 = new ListNode(4);
        // ListNode n6 = new ListNode(5);
        // ListNode n7 = new ListNode(6);
//  [2]
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(7);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(7);
        ListNode n6 = new ListNode(7);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        Solution s = new Solution();
        printList(n1);
//  [1]
        // ListNode result1 = s.removeElements(n1, 6);
        // printList(result1);
        // ListNode result2 = s.removeElements(n1, 1);
        // printList(result2);
//  [2]
        ListNode result3 = s.removeElements(n1, 7);
        printList(result3);
    }
}