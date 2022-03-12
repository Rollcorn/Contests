    /******************************************************************************************************************
     * 328-OddEven LinkedList
     * 
     * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with
     * even indices, and return the reordered list.
     * The first node is considered odd, and the second node is even, and so on.
     * Note that the relative order inside both the even and odd groups should remain as it was in the input.
     * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
     * 
     *  1 ---> 2 ---> 3 ---> 4 ---> 5
     * 
     *              |
     *             \|/
     *              '
     *  1 ---> 3 ---> 5 ---> 2 ---> 4
     * 
     * 
     */


public class OddEvenLinkedList {
//  1 ---> 2 ---> 3 ---> 4 ---> 5

    public ListNode oddEvenList(ListNode head) {
 
        ListNode lastOddNode = head;
        ListNode firstEvenNode = head;
        ListNode currentNode = firstEvenNode;

        while ( currentNode != null ) {

            ListNode nextNode = currentNode.next;
            
            if ( currentNode != head && nextNode != null ) {
                System.out.println( "current node-" + currentNode.val  + " next node-" + nextNode.val);
                lastOddNode.next = nextNode;
                lastOddNode = nextNode;
                currentNode.next = nextNode.next;
            }
            currentNode = currentNode.next; 
        }
        lastOddNode.next = firstEvenNode;

        return head;
    }

    public void printList( ListNode head ) {
        ListNode currNode = head;
        System.out.println( "[ ");
        int a = 0;
        while ( a != 15 && currNode != null ) {
            System.out.print(currNode.val + " ");
            a++;
            currNode = currNode.next;
        }
        System.out.println( " ]");
    }

    public static void main(String[] args) {
        // 2 1 3 5 6 4 7
        ListNode seventh = new ListNode(7);
        ListNode sixth = new ListNode(4);
        ListNode fivth = new ListNode(6);
        ListNode fourth = new ListNode(5);
        ListNode third = new ListNode(3);
        ListNode sec = new ListNode(1);
        // ListNode head = new ListNode(2);
        ListNode head = null;
        // head.next = sec;
        // sec.next = third;
        // third.next = fourth;
        // fourth.next = fivth;
        // fivth.next = sixth;
        // sixth.next = seventh;
        seventh.next = null;

        OddEvenLinkedList res = new OddEvenLinkedList(); 
        ListNode sortRes = res.oddEvenList(head);
        res.printList(sortRes);
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}