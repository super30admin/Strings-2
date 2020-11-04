# Time Complexity : O(n-l)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
# Your code here along with comments explaining your approach
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        L, n = len(needle), len(haystack)
        
        for start in range(n-L+1):
            if haystack[start: start+L] == needle:
                return start
        return -1
