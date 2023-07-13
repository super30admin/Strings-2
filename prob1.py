# Time Complexity :O(kn)
# Space Complexity :O(1)
# Leet Code: Yes

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(needle)
        for i in range(len(haystack)-n+1):
            if haystack[i:n+i] == needle:
                return i
        return -1