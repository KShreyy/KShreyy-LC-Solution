class Solution:
    def nextGreaterElement(self, nums1, nums2):
        # Dictionary to store the next greater element for each number in nums2
        next_greater = {}
        stack = []

        # Traverse nums2 in reverse to maintain a monotonic stack
        for num in reversed(nums2):
            # Maintain a decreasing stack (monotonic)
            while stack and stack[-1] <= num:
                stack.pop()
            
            # If the stack is not empty, the top of the stack is the next greater element
            next_greater[num] = stack[-1] if stack else -1
            
            # Add the current number to the stack
            stack.append(num)

        # For nums1, return the precomputed next greater elements
        return [next_greater[num] for num in nums1]



       
        