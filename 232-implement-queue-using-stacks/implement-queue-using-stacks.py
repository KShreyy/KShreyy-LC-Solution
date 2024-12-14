class MyQueue(object):

    def __init__(self):
        self.s1 = []  # Primary stack for enqueue
        self.s2 = []  # Secondary stack for dequeue

    def push(self, x):
        """
        Pushes element x to the back of the queue.
        :type x: int
        :rtype: None
        """
        self.s1.append(x)

    def pop(self):
        """
        Removes and returns the element from the front of the queue.
        :rtype: int
        """
        self._move_s1_to_s2()
        return self.s2.pop()

    def peek(self):
        """
        Returns the element at the front of the queue without removing it.
        :rtype: int
        """
        self._move_s1_to_s2()
        return self.s2[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return not self.s1 and not self.s2

    def _move_s1_to_s2(self):
        """
        Helper function to move elements from s1 to s2 if s2 is empty.
        This maintains the correct order for dequeue operations.
        """
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()