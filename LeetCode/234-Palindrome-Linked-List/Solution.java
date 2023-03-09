import java.util.Stack;

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

public class Solution {
	public boolean isPalindrome(ListNode head) {
		if (head.next == null) {
			return true;
		}
		Stack<ListNode> nodesStack = new Stack<>();
		ListNode forwardElement = head;
		
		while (forwardElement != null) {
			nodesStack.push(forwardElement);
			forwardElement = forwardElement.next;
		}
		
		int listSize = nodesStack.size();
		forwardElement = head;
		ListNode backwardElement = nodesStack.pop();
		int count = 0;
		boolean result = true;
		while (forwardElement != backwardElement && count < listSize / 2 && result) {
			if (forwardElement.val != backwardElement.val) {
				result = false;
			}
			count++;
			forwardElement = forwardElement.next;
			backwardElement = nodesStack.pop();
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode s5 = new ListNode(1, null);
		ListNode s4 = new ListNode(2, s5);
		ListNode s3 = new ListNode(3, s4);
		ListNode s2 = new ListNode(2, s3);
		ListNode s1 = new ListNode(1, s2);
		
		
		System.out.println(s.isPalindrome(s5));
	}
}
