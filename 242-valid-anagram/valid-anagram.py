class Solution(object):
    def isAnagram(self, s, t):
       setA=sorted(s)       
       setB=sorted(t)
       
        
       return setA==setB