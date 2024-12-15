class Solution(object):
    def isValid(self, s):
        st = []
        # Mapping of closing brackets to their corresponding opening brackets
        mapping = {')': '(', '}': '{', ']': '['}

        for char in s:
            # If the character is a closing bracket
            if char in mapping:
                # Check if the stack is not empty and the top matches the corresponding opening bracket
                if st and st[-1] == mapping[char]:
                    st.pop()
                else:
                    return False
            else:
                # It's an opening bracket, push it onto the stack
                st.append(char)

        # If the stack is empty, the string is valid
        return not st
