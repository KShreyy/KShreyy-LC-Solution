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
    public ListNode middleNode(ListNode head) {
        ListNode s=head;
        ListNode d=head;
        while(d!=null && d.next!=null){
            s=s.next;
            d=d.next.next;
             }
        return s;
    }
}
        
    