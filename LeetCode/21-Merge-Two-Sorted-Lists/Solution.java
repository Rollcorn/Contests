/*****************************************************************************************
 * TASK 21. Merge Two Sorted Lists
 * 
 * You are given the heads of two sorted linked lists list1 and list2.
 * 
 * Merge the two lists in a one sorted list. The list should be made by splicing together 
 * the nodes of the first two lists.
 * 
 * Return the head of the merged linked list.
 */


// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists( ListNode list1, ListNode list2 ) {
        
        ListNode firstNode = list1;
        ListNode secondNode = list2;

        ListNode resList = new ListNode();
        ListNode curResList = resList;

        while ( firstNode != null && secondNode != null ) {
            if ( firstNode.val < secondNode.val ) {
                curResList.next = new ListNode(firstNode.val);
                firstNode = firstNode.next;
            } else {
                curResList.next = new ListNode(secondNode.val);
                secondNode = secondNode.next;
            }
            curResList = curResList.next;
        }

        if ( firstNode == null ) {
            while ( secondNode != null ){
                curResList.next = new ListNode( secondNode.val );
                secondNode = secondNode.next;
                curResList = curResList.next;
            }
        } else if ( secondNode == null ) {
            while ( firstNode != null ) {
                curResList.next = new ListNode( firstNode.val );
                firstNode = firstNode.next;
                curResList = curResList.next;
            }
        }
        
        return resList.next;
    }
}
