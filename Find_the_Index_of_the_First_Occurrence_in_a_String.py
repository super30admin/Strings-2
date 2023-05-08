# Time complexity : O((n - m) * m), where n is the length of haystack and m is the length of needle
# Space Complexity : O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0
        
        if len(needle) > len(haystack):
            return -1
        
        for i in range(len(haystack) - len(needle) + 1):
            if haystack[i:i + len(needle)] == needle:
                return i
        
        return -1