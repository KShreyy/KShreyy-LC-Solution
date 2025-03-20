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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Count the total number of nodes
        ListNode end = head;
        int length = 1;
        while (end.next != null) {
            end = end.next;
            length++;
        }

        // Adjust k to be within bounds
        k = k % length;
        if (k == 0) return head; // No rotation needed

        // Find the new end (length - k - 1)
        ListNode temp = head;
        for (int i = 0; i < length - k - 1; i++) {
            temp = temp.next;
        }

        // New head will be temp.next
        ListNode newHead = temp.next;
        temp.next = null; // Break the list
        end.next = head; // Connect the old tail to the old head

        return newHead;
    }
}
