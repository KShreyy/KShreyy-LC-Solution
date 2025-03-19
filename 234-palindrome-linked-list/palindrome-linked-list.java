
class Solution {
    public boolean isPalindrome(ListNode head) {
        // Edge case: empty list or single node is always a palindrome
        if (head == null || head.next == null) 
            return true;
        
        // Find the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        slow = reverseLL(slow);
        ListNode left = head;
        ListNode right = slow;

        // Compare first half with the reversed second half
        while (right != null) {
            if (left.val != right.val) 
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reverseLL(ListNode head) {
        ListNode prev = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
