#Time Complexity : O(n)
#Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No




class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        if n==0:
            return 0
        for i in range(m-n+1):
            if haystack[i:i+n] == needle:
                return i
        return -1
        