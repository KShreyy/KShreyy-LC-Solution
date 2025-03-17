/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode a = head;
        
        // Count the number of nodes
        while (a != null) {
            count++;
            a = a.next;
        }
        
        // If we need to remove the first node (head)
        if (count == n) {
            return head.next;
        }

        ListNode b = head;

        // Stop at the node just before the one to be deleted
        for (int i = 0; i < count - n - 1; i++) {
            b = b.next;
        }

        // Remove the nth node from the end
        b.next = b.next.next;

        return head;
    }
}
