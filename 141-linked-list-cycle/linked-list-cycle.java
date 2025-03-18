/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // If the list is empty or has only one node, it cannot have a cycle
        if (head == null || head.next == null) return false;

        ListNode slow = head;  // Moves one step at a time
        ListNode fast = head;  // Moves two steps at a time

        while (fast != null && fast.next != null) { // Ensure fast and fast.next are valid
            slow = slow.next;         // Move slow one step
            fast = fast.next.next;     // Move fast two steps

            if (slow == fast) {  // If they meet, there is a cycle
                return true;
            }
        }
        return false; // If fast reaches the end, there is no cycle
    }
}
