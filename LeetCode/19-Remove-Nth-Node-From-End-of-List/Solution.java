
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

        if ( listSize > 0 ){
            currentNode = head;
        } else {
            currentNode = null;
        }
        
        
        for ( int i = 1; currentNode != null && i != n + 1; ++i ){
            currentNode = currentNode.next;
        }

        if (currentNode != null){
            currentNode.next = currentNode.next.next;
        }

        return head;
    }


}
