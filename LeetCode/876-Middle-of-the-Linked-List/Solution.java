/**
 * Definition for singly-linked list.
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 */
 class ListNode {
     int val;
     ListNode next = null;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode currentNode = head;
        int listSize = 0;
        while( currentNode != null ){
            listSize++;
            currentNode = currentNode.next;
        }

        currentNode = head;
        
        for ( int i = 1; currentNode != null && i != listSize/2 + 1; ++i ){
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public static void main(String[] args) {
        
    }
}