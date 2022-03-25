/*************************************************************************
 * TASK:
 *  Given the head of a linked list, remove the nth node from the end of 
 *  the list and return its head.
 *  https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * Constraints:
 *  1 <= sz <= 30
 *  0 <= Node.val <= 100
 *  1 <= n <= sz
 */

 class ListNode {
    int val;
    ListNode next = null;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currentNode = head;
        int listSize = 0;

        while( currentNode != null ){
            listSize++;
            currentNode = currentNode.next;
        }

        if( listSize == n ){
            head = head.next;
            return head;
        }
        else {
            currentNode = head;
        }

        // Поиск необходимого узла
        for ( int i = 1; i < listSize - n; ++i ){
            currentNode = currentNode.next;
        }

        currentNode.next = currentNode.next.next;
        return head;
    }

    public static void main(String[] args) {
        /**
         * Input: head = [1,2,3,4,5], n = 2
         * Output: [1,2,3,5]
         * 
         * Input: head = [1], n = 1
         * Output: []
         * 
         * Input: head = [1,2], n = 1
         * Output: [1]
         * 
         */

    }

}
