class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle is None or haystack is None or len(needle) == 0:
            return 0
        
        m = len(needle)
        n = len(haystack)
        
        for s in range(n - m + 1):            
            for i in range(m):
                if needle[i] != haystack[s + i]:
                    break
                if i == m - 1:
                    return s
        return -1