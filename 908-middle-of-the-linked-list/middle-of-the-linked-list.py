# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def middleNode(self, head):
        fast = head
        slow = head
        while fast and fast.next:  # Check both fast and fast.next
            fast = fast.next.next
            slow = slow.next
        head=slow
        return head  # Return the value of the middle node

        
        