public class Solution {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode middle = findListMiddleNode(head);
		ListNode rBegin = middle.next;
		middle.next = null;
		
		ListNode left = sortList(head);
		ListNode right = sortList(rBegin);
		
		return merge(left, right);
	}
	
	private ListNode merge(ListNode first, ListNode second) {
		if (first == null) {
			return second;
		}
		if (second == null) {
			return first;
		}
		ListNode result;
		if (first.val <= second.val) {
			result = first;
			result.next = merge(first.next, second);
		} else {
			result = second;
			result.next = merge(first, second.next);
		}
		return result;
	}
	
	public ListNode findListMiddleNode(ListNode begin) {
		if (begin.next == null) {
			return begin;
		}
		ListNode slow = begin;
		ListNode fast = begin.next;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	static class ListNode {
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
	
	static void printList(ListNode head) {
		System.out.print("[");
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.print("]");
	}
	
	public static void main(String[] args) {
		ListNode n5 = new ListNode(1, null);
		ListNode n4 = new ListNode(2, n5);
		ListNode n3 = new ListNode(3, n4);
		ListNode n2 = new ListNode(4, n3);
		ListNode n1 = new ListNode(5, n2);
		
		Solution s = new Solution();
		printList(n1);
		System.out.println();
		printList(s.sortList(n1));
	}
}
