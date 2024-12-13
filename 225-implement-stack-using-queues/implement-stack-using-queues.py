from collections import deque

class MyStack(object):

    def __init__(self):
        self.q = deque()

    def push(self, x):
        # Add the new element to the deque
        self.q.append(x)
        # Rotate the deque to bring the new element to the front
        for _ in range(len(self.q) - 1):
            self.q.append(self.q.popleft())

    def pop(self):
        # Remove and return the top element
        return self.q.popleft()
        
    def top(self):
        # Return the top element without removing it
        return self.q[0]
        
    def empty(self):
        # Return True if the deque is empty, otherwise False
        return len(self.q) == 0


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()