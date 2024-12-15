class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
            
            needle_l = len(needle)
            for i in range(len(haystack)):
                if haystack[i:i+needle_l] == needle:
                    return i
            
            return -1
