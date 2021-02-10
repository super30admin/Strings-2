# Time Complexity : O(MN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        """
        just use slicing? or just use two pointers to find matches in needle and haystack
        """
        if not needle:
            return 0 
        
        m = len(haystack)
        n = len(needle)
        
        for i in range(m-n+1):
            if haystack[i:i+n] == needle:
                return i
            
        return -1