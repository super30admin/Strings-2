# Implement strStr()

# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes, with Runtime: 48 ms and Memory Usage: 14.5 MB
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
# Approach
"""
Using Brute Force Approach, we match pattern/needle in input/haystack. If 
it mismatches we take pointer back. 

"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if(needle==None or len(needle)==0): # base case
            return 0
        if(len(haystack)<len(needle)): # base case
            return -1
        for i in range(len(haystack)-len(needle)+1):
            k=i
            for j in range(len(needle)):
                if(haystack[i] != needle[j]):
                    break
                i=i+1
            else:
                return k
        return -1

# The problem can also be solved using KMP Approach.