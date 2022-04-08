/**
 * TASK
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 */

//  Definition for singly-linked list.
  class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
 public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curentNode = head;
        ListNode prevNode = null;
        ListNode nextNode;

        while ( curentNode != null ){
            nextNode = curentNode.next;
            curentNode.next = prevNode;
            prevNode = curentNode;
            curentNode = nextNode;
        }
        head = prevNode;

        return head;
    }


    public static void main(String[] args) {
        
    }
}