import java.util.HashSet;

/**
 * Task 83. Remove Duplicates from Sorted List
 * */
//  Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {    
    // [1 var] delete duplicates from usorted list
    public ListNode deleteDuplicates(ListNode head) {
        if ( head == null || head.next == null) {
            return head;
        }

        HashSet<Integer> nodeSet = new HashSet<>();
        ListNode curNode = head;
        nodeSet.add(curNode.val);

        while (  curNode.next != null ) {
            if ( nodeSet.add(curNode.next.val ) ) {
                curNode = curNode.next;
            } else {
                curNode.next = curNode.next.next;
            }
        }
        return head;
    }

    /**
     *     ListNode fakeHead = head;
     *      while(fakeHead != null && fakeHead.next != null){
     *          if(fakeHead.val == fakeHead.next.val){
     *          fakeHead.next = fakeHead.next.next;
     *          } else{
     *          fakeHead = fakeHead.next;
     *      }
     *      }
     *      return head;
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
        ListNode result3 = s.deleteDuplicates(n1);
        printList(result3);
            }
}